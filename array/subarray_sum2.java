//better code
public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int count = 0, n = A.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            preSum[i] += A[i - 1] + preSum[i - 1];
            count  += helper(preSum, 0, i - 1, preSum[i] - start)
                    - helper(preSum, 0, i - 1, preSum[i] - end - 1);
        }
        return count;
    }
    public int helper(int[] preSum, int start, int end, int target) {
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(preSum[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(preSum[end] <= target) {
            return end + 1;
        } else if(preSum[start] <= target) {
            return start + 1;
        } else {
            return 0;
        }
    }
}
//first version
public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int count = 0, sum = 0, n = A.length;
        int[] preSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            preSum[i] += A[i - 1] + preSum[i - 1];
            if(preSum[i] < start || A[i - 1] > end) continue;
            int left = helper(preSum, 0, i - 1, preSum[i] - end, true);
            int right = helper(preSum, 0, i - 1, preSum[i] - start, false);
            if(right >= left) {
                count += right - left + 1;
            }

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
