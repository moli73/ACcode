//DFS, traversal version, the helper function is void return.
public class Solution {
    private boolean res;
    public boolean exist(char[][] board, String word) {
        res = false;
        if(board.length == 0 || board[0].length == 0){
            return res;
        }

        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == word.charAt(0)){
                    helper(board, word, i, j, 1);
                }
            }
        }

        return res;
    }

    public void helper(char[][] board, String word, int i, int j, int pos){
        if(pos == word.length()){
            res = true;
            return;
        }
        if(res == true) return;//key point: eliminate the TLE

        // char temp = board[i][j];
        board[i][j] = '?';//key point: mark the scanned cell

        if(i != 0 && board[i - 1][j] == word.charAt(pos)){
            helper(board, word, i - 1, j, pos + 1);
        }

        if(i != board.length - 1 && board[i + 1][j] == word.charAt(pos)){
            helper(board, word, i + 1, j, pos + 1);
        }

        if(j != 0 && board[i][j - 1] == word.charAt(pos)){
            helper(board, word, i, j - 1, pos + 1);
        }

        if(j != board[0].length - 1 && board[i][j + 1] == word.charAt(pos)){
            helper(board, word, i, j + 1, pos + 1);
        }

        // board[i][j] = temp;
        board[i][j] = s.charAt(pos); //board[i][j] and s.charAt(pos) are matched, so use it to recover.
    }
}

//version 2: DFS, Divide and Conquer, the helper function has boolean return
public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) { return false;}
        if(word == null || word.length() == 0) { return true;}

        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(helper(board, i, j, word, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int pos){
        if(pos == word.length()) { return true;}
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(pos) != board[i][j]){
            return false;
        }

        board[i][j] = '?';
        boolean res = helper(board, i - 1, j, word, pos + 1) ||
             			helper(board, i + 1, j, word, pos + 1) ||
             			helper(board, i, j - 1, word, pos + 1) ||
             		  	helper(board, i, j + 1, word, pos + 1);

        board[i][j] = word.charAt(pos);

        return res;
    }
}
