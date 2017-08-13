public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = 1;
        }
        int down = 1, up = 1;
        for(int i = 0; i < n; i++) {
            res[i] *= up;
            up *= nums[i];
            res[n - 1 - i] *= down;
            down *= nums[n - 1 - i];
        }
        return res;
    }
}
