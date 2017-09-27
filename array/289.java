class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        int[] dx = {1,1,1,0,0,-1,-1,-1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 1) {
                    for(int k = 0; k < 8; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if(x >= 0 && x < m && y >= 0 && y < n) {
                            count[x][y]++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if((board[i][j] == 0 && count[i][j] == 3) ||
                   (board[i][j] == 1 && (count[i][j] == 2 || count[i][j] == 3))) {
                    board[i][j] = 1;
                } else if(board[i][j] == 1 && (count[i][j] != 2 || count[i][j] != 3)){
                    board[i][j] = 0;
                }
            }
        }
    }
}
