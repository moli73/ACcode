public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for(int k = 0; k < nums.length; k++) {
            if(k != 0 && nums[k] == nums[k - 1]) continue;

            int target = -nums[k];
            int i = k + 1, j = nums.length - 1;
            while(i < j) {
                if(nums[i] + nums[j] == target) {
                    List<Integer> comb = new ArrayList<>();
                    comb.add(-target);
                    comb.add(nums[i]);
                    comb.add(nums[j]);
                    res.add(new ArrayList<Integer>(comb));
                    i++;
                    j--;
                } else if(nums[i] + nums[j] > target) {
                    j--;
                } else {
                    i++;
                }

                while(i < j && i != k + 1 && nums[i] == nums[i - 1]) {
                    i++;
                }
                while(i < j && j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                }
            }
        }
        return res;
    }
}
