public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] leftMax = new int[n - 1];
        int[] rightMin = new int[n - 1];
        int[] leftMin = new int[n - 1];
        int[] rightMax = new int[n - 1];

        int max = Integer.MIN_VALUE, minPreSum = 0, sum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minPreSum);
            leftMax[i] = max;
            minPreSum = Math.min(minPreSum, sum);
        }

        max = Integer.MIN_VALUE; minPreSum = 0; sum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum -= nums[i];
            max = Math.max(max, sum - minPreSum);
            leftMin[i] = -max;
            minPreSum = Math.min(minPreSum, sum);
        }

        max = Integer.MIN_VALUE; minPreSum = 0; sum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum += nums[n - 1 - i];
            max = Math.max(max, sum - minPreSum);
            rightMax[i] = max;
            minPreSum = Math.min(minPreSum, sum);
        }
        max = Integer.MIN_VALUE; minPreSum = 0; sum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum -= nums[n - 1 - i];
            max = Math.max(max, sum - minPreSum);
            rightMin[i] = -max;
            minPreSum = Math.min(minPreSum, sum);
        }
        int res = 0;
        for(int i = 0; i < n - 1; i++) {
            res = Math.max(res, leftMax[i] - rightMin[n - 2 - i]);
            res = Math.max(res, rightMax[n - 2 - i] - leftMin[i]);
        }
        return res;
    }
}
