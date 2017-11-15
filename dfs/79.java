class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m == 0) return word.length() == 0;
        int n = board[0].length;
        if(n == 0) return word.length() == 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int pos = 0;

                if(helper(board, i, j, word, pos) == true) {
                    return true;
                }

            }
        }
        return false;
    }

    private boolean helper(char[][] board, int i, int j, String word, int pos) {
        if(pos == word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(pos) != board[i][j]) {
            return false;
        }

        board[i][j] = '#';   注意标注成visited

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        boolean res = false;

        for(int k = 0; k < 4; k++) {
            if(res == false) {
                res = res || helper(board, i + dx[k], j + dy[k], word, pos + 1);
            }
        }

        board[i][j] = word.charAt(pos);   注意恢复

        return res;
    }
}
