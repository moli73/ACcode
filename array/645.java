class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(i != nums[i] - 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }

        int[] res = new int[2];
        for(int i = 0; i < n; i++) {
            if(i != nums[i] - 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
