二维展开成一维数组建立father数组
time:O(k + mn)
space: O(mn)
find:
time O(logn)
time O(1)  <----- compressed find

public class Solution {
    private int[] father = null;
    private int count = 0;
    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        father = new int[m * n];
        boolean[] isLand = new boolean[m * n];
        for(int i = 0; i < m * n; i++) {
            father[i] = i;
        }
        List<Integer> res = new ArrayList<>();
        int[] d = {-1, 0, 1, 0, -1};
        for(int[] pos : positions) {
            isLand[n * pos[0] + pos[1]] = true;
            count++;

            for(int k = 0; k < 4; k++) {
                int i = pos[0] + d[k], j = pos[1] + d[k + 1];
                if(i < 0 || i >= m || j < 0 || j >= n || !isLand[n * i + j]) continue;

                union(n * pos[0] + pos[1], n * i + j);
            }
            res.add(count);
        }
        return res;
    }
}

solutoin 2: DFS
class Solution {
    private int[] dx = {-1,0,1,0};
    private int[] dy = {0,-1,0,1};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int k = positions.length;
        int cnt = 0;
        int[][] board = new int[m][n];

        for(int t = 0; t < k; t++) {
            int x = positions[t][0];
            int y = positions[t][1];

            boolean[][] visited = new boolean[m][n];
            int count = 0;

            //DFS 当前点附近有多少个独立的岛屿
            for(int tt = 0; tt < 4; tt++) {
                int i = x + dx[tt];
                int j = y + dy[tt];
                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true || board[i][j] == 0) continue;
                count++;
                helper(board, visited, i, j);
            }
            board[x][y] = 1;
            cnt = cnt - count + 1;
            res.add(cnt);
        }

        return res;
    }

    public void helper(int[][] board, boolean[][] visited, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true || board[i][j] == 0) return;
        visited[i][j] = true;
        for(int k = 0; k < 4; k++) {
            helper(board, visited, i + dx[k], j + dy[k]);
        }
    }
}
