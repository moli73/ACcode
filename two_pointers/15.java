class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int k = 0; k < nums.length; k++) {
            if(k != 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            int target = -nums[k];
            while(i < j) {
                if(nums[i] + nums[j] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[k]);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    res.add(new ArrayList<Integer>(temp));
                    i++;
                    j--;
                } else if(nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
                while(i != k + 1 && i < j && nums[i] == nums[i - 1]) i++;
                while(j != nums.length - 1 && i < j && nums[j] == nums[j + 1]) j--;
            }
        }
        return res;
    }
}
