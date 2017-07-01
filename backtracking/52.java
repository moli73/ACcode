public class Solution {
    private int count;
    public int totalNQueens(int n) {
        count = 0;
        if(n < 1) { return count;}

        int[] rows = new int[n];
        helper(0, rows, n);
        return count;
    }

    public void helper(int col, int[] rows, int n){
        if(col == n){
            count++;
            return;
        }

        //rows[col] = -1;
        for(int i = 0; i < n; ++i){
            if(isValid(i, col, rows)){
                rows[col] = i;
                helper(col + 1, rows, n);
                rows[col] = -1;//any number is ok
            }
        }
    }

    public boolean isValid(int row, int col, int[] rows){
        for(int i = 0; i < col; ++i){
            if(rows[i] == row || rows[i] - row == i - col || i - col == row - rows[i]){
                return false;
            }
        }
        return true;
    }
}
