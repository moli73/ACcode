//DFS: 先判断，然后递归，能通过。
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) { return;}

        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == 'O')
                helper(board, i, 0);
            if(board[i][board[0].length - 1] == 'O')
                helper(board, i, board[0].length - 1);
        }

        for(int j = 0; j < board[0].length; j++) {
            if(board[0][j] == 'O')
                helper(board, 0, j);
            if(board[board.length - 1][j] == 'O')
                helper(board, board.length - 1, j);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void helper(char[][] board, int i, int j) {
        board[i][j] = 'B';
        if(i > 1 && board[i - 1][j] == 'O')
            helper(board, i - 1, j);

        if(i < board.length - 1 && board[i + 1][j] == 'O')
            helper(board, i + 1, j);

        if(j > 1 && board[i][j - 1] == 'O')
            helper(board, i, j - 1);

        if(j < board[0].length - 1 && board[i][j + 1] == 'O')
            helper(board, i, j + 1);
    }
}
//DFS: 先递归再判断，会stack overflow
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) { return;}

        for(int i = 0; i < board.length; i++) {
            helper(board, i, 0);
            helper(board, i, board[0].length - 1);
        }

        for(int j = 0; j < board[0].length; j++) {
            helper(board, 0, j);
            helper(board, board.length - 1, j);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void helper(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if(board[i][j] == 'X' || board[i][j] == 'B') {
            return;
        }
        board[i][j] = 'B';
        helper(board, i - 1, j);
        helper(board, i + 1, j);
        helper(board, i, j - 1);
        helper(board, i, j + 1);
    }
}
