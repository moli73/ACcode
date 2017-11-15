class NumArray {

    private int[] preSum;

    public NumArray(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        preSum[0] = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            preSum[i + 1] = sum;
        }
    }

    public int sumRange(int i, int j) {
        return preSum[j + 1] - preSum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
