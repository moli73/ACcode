//version 1:dynamic programming
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
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


/*
nums 1,3,2,4,5,6,7,8

dp 1,2,3,4,5,6,7,8
   1 2
binary search : to find the last smaller than nums[i]


*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];//the tail of the LIS of length i
        dp[0] = Integer.MIN_VALUE;

        int max = 0;
        for(int i = 0; i < n; i++) {
            int left = 0;
            int right = max;
            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(dp[mid] >= nums[i]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            int index = 0;//the biggest number smaller than nums[i]
            if(nums[i] > dp[right]) {
                index = right;
            } else {
                index = left;
            }

            if(index == max) {
                dp[index + 1] = nums[i];
                max = index + 1;
            } else {
                dp[index + 1] = Math.min(dp[index + 1], nums[i]);
            }
        }
        return max;
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
