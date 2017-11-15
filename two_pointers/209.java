class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = 0;
        int start = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                if(len == 0 || i - start + 1 < len) {
                    len = i - start + 1;
                }
                sum -= nums[start];
                start++;
            }
        }
        return len;
    }
}
//jiuzhang version
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
