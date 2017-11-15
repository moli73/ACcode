class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            while(i != nums[i] && nums[nums[i]] != nums[i]) {
                swap(nums, i, nums[i]);
            }
        }
        return nums[0];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
