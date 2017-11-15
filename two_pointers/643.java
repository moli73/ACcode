class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0.0;
        int start = 0;
        double sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(i >= k - 1) {
                res = Math.max(res, sum / k);
                sum -= nums[start++];
            }
        }
        return res;
    }
}
