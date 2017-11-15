class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int a = nums[left];
                int b = nums[right];
                int c = nums[i];
                int sum = a + b + c;
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    res.add(new ArrayList<Integer>(temp));
                }
                if(sum >= 0) {
                    while(left < right && nums[right] == b) right--;
                }
                if(sum <= 0) {
                    while(left < right && nums[left] == a) left++;
                }
            }
        }
        return res;
    }
}
