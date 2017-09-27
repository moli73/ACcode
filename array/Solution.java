import java.util.*;

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] A = {1,2,3,4};
        int start = 1, end = 3;

        System.out.println(sol.subarraySumII(A, start, end));
    }
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int count = 0, sum = 0, n = A.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            preSum[i] += A[i - 1] + preSum[i - 1];
            if(preSum[i] < start || A[i - 1] > end) continue;
            int left = helper(preSum, 0, i - 1, preSum[i] - end, true);
            int right = helper(preSum, 0, i - 1, preSum[i] - start, false);
            System.out.println("left: " + left);
            System.out.println("right: " + right);
                count += right - left + 1;


        }
        return count;
    }
    public int helper(int[] preSum, int start, int end, int target, boolean flag) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(preSum[mid] == target) {
                if(flag) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if(preSum[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(flag) {
            if(preSum[start] >= target) {
                return start;
            } else {
                return end;
            }
        } else {
            if(preSum[end] <= target) {
                return end;
            } else {
                return start;
            }
        }
    }
}
