public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        int sum = 0, res = Integer.MIN_VALUE, minPreSum = 0;
        for(int num : nums) {
            sum -= num;
            res = Math.max(res, sum - minPreSum);
            minPreSum = Math.min(minPreSum, sum);
        }
        return -res;
    }
}
//better code
public class Solution {
    int sum = 0, res = Integer.MAX_VALUE, maxPre = 0;
        for(int num : nums) {
            sum += num;
            if(sum - maxPre < res) {
                res = sum - maxPre;
            }
            if(sum > maxPre) {
                sum = maxPre;
            }
        }
        return res;
    }
}
