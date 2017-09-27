class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                count++;
            } else {
                res = Math.max(res, count);
                count = 1;// key point
            }
        }
        res = Math.max(res, count);
        return res;
    }
}
