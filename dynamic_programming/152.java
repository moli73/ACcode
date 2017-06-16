public class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length; if(n == 0) return 0;
        int res = nums[0], neg = nums[0], pos = nums[0];
        for(int i = 1; i < n; ++i){
            int temp1 = neg, temp2 = pos;
            neg = Math.min(nums[i], Math.min(temp1 * nums[i], temp2 * nums[i]));
            pos = Math.max(nums[i], Math.max(temp1 * nums[i], temp2 * nums[i]));
            res = Math.max(res, pos);
        }
        return res;
    }
}
