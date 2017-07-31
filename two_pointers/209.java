public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int res = 0, sum = 0, n = nums.length;
        int i = 0, j = 0;
        for(i = 0; i < n; i++) {
            while(j < n && sum < s) {
                sum += nums[j];
                j++;
            }

            if(sum >= s && (res == 0 || res > j - i)) {
                res = j - i;
            }

            sum -= nums[i];
        }
        return res;
    }
}
