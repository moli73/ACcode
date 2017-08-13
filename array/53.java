public class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, minPreSum = 0, curPreSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            res = Math.max(curPreSum - minPreSum, res);
            minPreSum = Math.min(minPreSum, curPreSum);
        }
        return res;
    }
}
