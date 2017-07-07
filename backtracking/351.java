public class Solution {

    private int res = 0;

    public int numberOfPatterns(int m, int n) {
        res = 0;
        boolean[] isUsed = new boolean[9];
        helper(isUsed, 0, m, n, -1);
        return res;
    }

    public void helper(boolean[] isUsed, int count, int m, int n, int pre){
        if(count >= m && count <= n){
            res++;
            if(count == n){
                return;
            }
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(isUsed[3 * i + j]) continue;
                if(count != 0 && !isValid(pre, i, j, isUsed)) continue;

                isUsed[3 * i + j] = true;
                helper(isUsed, count + 1, m, n, 3 * i + j);
                isUsed[3 * i + j] = false;
            }
        }
    }

    public boolean isValid(int pre, int i, int j, boolean[] isUsed){
        int m = pre / 3;
        int n = pre % 3;

        if(Math.abs(m - i) == 2 && n == j){
            if(!isUsed[3 + j])
                return false;
        }

        if(Math.abs(n - j) == 2 && m == i && !isUsed[3 * i + 1]){
            return false;
        }

        if(Math.abs(n -j) == 2 && Math.abs(m - i) == 2 && !isUsed[4]){
            return false;
        }

        return true;

    }
}
