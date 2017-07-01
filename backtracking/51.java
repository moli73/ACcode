public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n < 1) { return res;}

        char[][] board = new char[n][n];
        int[] rows = new int[n];
        helper(res, board, 0, rows, n);
        return res;
    }

    public void helper(List<List<String>> res, char[][] board, int col, int[] rows, int n){
        if(col == n){
            res.add(new ArrayList<String>(makeBoard(board)));
            return;
        }

        //rows[col] = -1;
        for(int i = 0; i < n; ++i){
            if(isValid(i, col, rows)){
                board[i][col] = 'Q';
                rows[col] = i;
                helper(res, board, col + 1, rows, n);
                board[i][col] = ' ';//any char is ok
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

    public List<String> makeBoard(char[][] board){
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; ++i){
            String line = new String();
            for(int j = 0; j < board.length; ++j){
                if(board[i][j] == 'Q'){
                    line += 'Q';
                } else {
                    line += '.';
                }
            }
            res.add(line);
        }
        return res;
    }
}
