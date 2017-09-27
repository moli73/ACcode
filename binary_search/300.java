//binary search
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n + 1];
        tails[0] = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0; i < n; i++) {
            int left = 0, right = res, mid = 0;
            while(left + 1 < right) {
                mid = left + (right - left) / 2;
                if(tails[mid] < nums[i]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            int index = 0;
            if(tails[right] < nums[i]) {
                index = right;
            } else {
                index = left;
            }
            tails[index + 1] = nums[i];
            if(index + 1 > res) {
                res = index + 1;
            }
        }
        return res;
    }
}
