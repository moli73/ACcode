public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) {
            return false;
        }

        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(helper(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, int i, int j, String word, int pos) {
        if(pos == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)) {
            return false;
        }
        board[i][j] = '#';
        boolean cur = false;
        cur = cur || helper(board, i + 1, j, word, pos + 1);
        cur = cur || helper(board, i - 1, j, word, pos + 1);
        cur = cur || helper(board, i, j + 1, word, pos + 1);
        cur = cur || helper(board, i, j - 1, word, pos + 1);
        board[i][j] = word.charAt(pos);
        return cur;
    }
}
