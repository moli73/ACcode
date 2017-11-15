public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double start = Integer.MAX_VALUE, end = Integer.MIN_VALUE;
        for(int num : nums) {
            start = Math.min(start, num);
            end = Math.max(end, num);
        }
        double eps = 1e-8;
        while(end - start > eps) {
            double mid = start + (end - start) / 2;
            if(isValid(nums, mid, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public boolean isValid(int[] nums, double mid, int k) {
        int n = nums.length;
        double[] preDiffSum = new double[n + 1];
        double minPreDiffSum = 0;
        preDiffSum[0] = 0;
        for(int i = 1; i <= n; i++) {
            preDiffSum[i] = preDiffSum[i - 1] + nums[i - 1] - mid;
            if(i >= k && preDiffSum[i] - minPreDiffSum >= 0) {
                return true;
            }
            if(i >= k) {
                minPreDiffSum = Math.min(minPreDiffSum, preDiffSum[i - k + 1]);
            }
        }
        return false;
    }
}
