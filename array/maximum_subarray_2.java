public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        int n = nums.size();
        int[] left = new int[n - 1];
        int[] right = new int[n -1];

        int sum = 0, max = Integer.MIN_VALUE, minPreSum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum += nums.get(i);
            max = Math.max(max, sum - minPreSum);
            left[i] = max;
            minPreSum = Math.min(minPreSum, sum);
        }

        sum = 0; max = Integer.MIN_VALUE; minPreSum = 0;
        for(int i = 0; i < n - 1; i++) {
            sum += nums.get(n - 1 - i);
            max = Math.max(max, sum - minPreSum);
            right[i] = max;
            minPreSum = Math.min(minPreSum, sum);
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n - 1; i++) {
            res = Math.max(res, left[i] + right[n - 2 - i]);
        }

        return res;
    }
}
