//version 1: backtracking O(n!)
public class Solution {
    private int res;
    public int countNumbersWithUniqueDigits(int n) {
        res = 0;
        if(n == 0) return 1;//corner case
        boolean[] used = new boolean[10];
        helper(used, 0, n);
        res -= 1;//eliminate the root count
        return res;
    }

    public void helper(boolean[] used, int pos, int n){
        if(pos <= n){
            res++;
            if(pos == 1 && used[0]){
                return;
            }
        } else {
            return;
        }
        for(int i = 0; i <= 9; ++i){
            if(used[i]) continue;
            used[i] = true;
            helper(used, pos + 1, n);
            used[i] = false;
        }
    }
}

//version 2: math
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) { return 1;}

        int res = 10, count = 9;
        for(int i = 2; i <= n && i <= 10; ++i){
            count *= 11 - i;
            res += count;
        }

        return res;
    }
}
