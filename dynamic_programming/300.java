//version 1:dynamic programming
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        int res = 1;
        dp[0] = 1;
        for(int i = 1; i < n; ++i){
            dp[i] = 1;
            for(int j = 0; j < i; ++j){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//version 2: binary search
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n + 1];//tails[i] presents the minTails of the length of i of subsequence
        int res = 0;
        tails[0] = Integer.MIN_VALUE;//initialization
        for(int i = 0; i < n; ++i){
            int left = 0, right = res;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(tails[mid] < nums[i]) left = mid;
                else right = mid;
            }//the first larger tails always be right one
            if(tails[right] < nums[i]){
                res++;
                tails[res] = nums[i];
            } else tails[right] = nums[i];
        }
        return res;
    }
}
(1) if x is larger than all tails, append it, increase the size by 1
(2) if tails[i-1] < x <= tails[i], update tails[i]
// O(nlogn) Binary Search， from jiuzhang
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= n; ++i){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < n; ++i){
            int left = 0, right = n;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(dp[mid] <= nums[i]) left = mid;
                else right = mid;
            }
            if(dp[left] >= nums[i]) dp[left] = nums[i];
            else dp[right] = nums[i];
        }

        for(int i = n; i >= 0; --i){
            if(dp[i] != Integer.MAX_VALUE){
                return i;
            }
        }
        return 0;
    }
}
