class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0 || k == 1) return 0;

        int start = 0;
        long product = 1;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while(product >= k && start <= i) {
                product /= nums[start];
                start++;
            }
            res += i - start + 1;
        }
        return res;
    }
}
