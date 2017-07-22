//BFS from boarder
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                helper(i, 0, board);
            }
            if(board[i][n - 1] == 'O') {
                helper(i, n - 1, board);
            }
        }

        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                helper(0, j, board);
            }
            if(board[m - 1][j] == 'O') {
                helper(m - 1, j, board);
            }
        }

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void helper(int i, int j, char[][] board) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        board[i][j] = 'B';
        qx.offer(i);
        qy.offer(j);

        while(!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            if(x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = 'B';
                qx.offer(x - 1);
                qy.offer(y);
            }
            if(x < board.length - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = 'B';
                qx.offer(x + 1);
                qy.offer(y);
            }
            if(y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = 'B';
                qx.offer(x);
                qy.offer(y - 1);
            }
            if(y < board[0].length - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = 'B';
                qx.offer(x);
                qy.offer(y + 1);
            }

        }
    }
}
//better code
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') {
                board[i][0] = 'B';
                qx.offer(i);
                qy.offer(0);
            }
            if(board[i][n - 1] == 'O') {
                board[i][n - 1] = 'B';
                qx.offer(i);
                qy.offer(n - 1);
            }
        }

        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') {
                board[0][j] = 'B';
                qx.offer(0);
                qy.offer(j);
            }
            if(board[m - 1][j] == 'O') {
                board[m - 1][j] = 'B';
                qx.offer(m - 1);
                qy.offer(j);
            }
        }

        while(!qx.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();

            if(x > 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = 'B';
                qx.offer(x - 1);
                qy.offer(y);
            }
            if(x < board.length - 1 && board[x + 1][y] == 'O') {
                board[x + 1][y] = 'B';
                qx.offer(x + 1);
                qy.offer(y);
            }
            if(y > 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = 'B';
                qx.offer(x);
                qy.offer(y - 1);
            }
            if(y < board[0].length - 1 && board[x][y + 1] == 'O') {
                board[x][y + 1] = 'B';
                qx.offer(x);
                qy.offer(y + 1);
            }

        }

        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

}
//naive solution
public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        List<int[]> flips = new ArrayList<>();

        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 1; i < board.length - 1; i++) {
            for(int j = 1; j < board[0].length - 1; j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {

                    boolean flag = true;
                    Queue<int[]> q = new LinkedList<>();
                    int[] start = new int[2];//tricky
                    start[0] = i;
                    start[1] = j;
                    q.offer(start);

                    List<int[]> flipsCand = new ArrayList<>();
                    flipsCand.add(start);
                    visited[i][j] = true;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();
                        int m = cur[0], n = cur[1];
                        if(m == 0 || m == board.length - 1 || n == 0 || n == board[0].length - 1) {
                            flag = false;
                        }

                        if(m != 0 && board[m - 1][n] == 'O' && !visited[m - 1][n]) {
                            int[] temp = new int[2];//tricky
                            visited[m - 1][n] = true;
                            temp[0] = m - 1;
                            temp[1] = n;
                            q.offer(temp);
                            flipsCand.add(temp);
                        }
                        if(m != board.length - 1 && board[m + 1][n] == 'O' && !visited[m + 1][n]) {
                            int[] temp = new int[2];
                            visited[m + 1][n] = true;
                            temp[0] = m + 1;
                            temp[1] = n;
                            q.offer(temp);
                            flipsCand.add(temp);
                        }
                        if(n != 0 && board[m][n - 1] == 'O' && !visited[m][n - 1]) {
                            int[] temp = new int[2];
                            visited[m][n - 1] = true;
                            temp[0] = m;
                            temp[1] = n - 1;
                            q.offer(temp);
                            flipsCand.add(temp);
                        }
                        if(n != board[0].length - 1 && board[m][n + 1] == 'O' && !visited[m][n + 1]) {
                            int[] temp = new int[2];
                            visited[m][n + 1] = true;
                            temp[0] = m;
                            temp[1] = n + 1;
                            q.offer(temp);
                            flipsCand.add(temp);
                        }
                    }
                    if(flag) {
                        flips.addAll(flipsCand);
                    }
                }
            }
        }

        for(int[] cur : flips) {
            board[cur[0]][cur[1]] = 'X';
        }
    }
}
