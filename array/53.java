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

//better code
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        int minPreSum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum - minPreSum > res) {
                res = sum - minPreSum;
            }
            if(sum < minPreSum) {
                minPreSum = sum;
            }
        }
        return res;
    }
}
