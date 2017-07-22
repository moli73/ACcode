public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();

        if(board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else {
            board[click[0]][click[1]] = 'B';
        }

        int[] dx = {1, 1, 0, -1, -1, -1,  0, 1};
        int[] dy = {0, 1, 1,  1,  0, -1, -1, -1};

        q.offer(click);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            int count = 0;

            for(int k = 0; k < 8; k++) {
                int i = cur[0] + dx[k], j = cur[1] + dy[k];
                if(i < 0 || i >= m || j < 0 || j >= n) continue;
                if(board[i][j] == 'M') {
                    count++;
                }
            }//先查雷

            if(count != 0) {
                board[cur[0]][cur[1]] = (char)('0' + count);//说明当前点应该变成数字，数字旁边的E不能变B
            } else {//说明当前点应该变B,它的adj中是E的就应该入队，继续搜索
                for(int k = 0; k < 8; k++) {
                    int i = cur[0] + dx[k], j = cur[1] + dy[k];

                    if(i < 0 || i >= m || j < 0 || j >= n) continue;
                    if(board[i][j] == 'E') {
                        board[i][j] = 'B';//变B表明已经遍历过，在它出队的时候会决定是数字还是继续是B
                        q.offer(new int[] {i, j});
                    }
                }
            }
        }

        return board;
    }
}
