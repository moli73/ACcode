public class Solution {
    public int maxRotateFunction(int[] A) {
        int dp = 0, n = A.length, res = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; ++i){
            sum += A[i];
            dp += A[i] * i;
        }
        res = Math.max(res, dp);
        for(int i = n - 1; i > 0; --i){
            dp = dp + sum - A[i] * n;
            res = Math.max(res, dp);
        }
        return res;
    }
}
