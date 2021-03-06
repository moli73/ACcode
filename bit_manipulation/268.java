public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }

        return res ^ nums.length;
    }
}
