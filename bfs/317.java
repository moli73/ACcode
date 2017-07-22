//version 1: BFS without change the grid
public class Solution {

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int total = 0, m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] count = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    total++;
                    bfs(grid, new Point(i, j), distance, count);
                }
            }
        }

        int res = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && count[i][j] == total) {
                    if(res == -1) {
                        res = distance[i][j];
                    } else {
                        res = Math.min(res, distance[i][j]);
                    }
                }
            }
        }

        return res;
    }

    public void bfs(int[][] grid, Point s, int[][] distance, int[][] count) {
        int[] delta = {1, 0, -1, 0, 1};
        int m = grid.length, n = grid[0].length;
        int[][] level = new int[m][n];
        Queue<Point> q = new LinkedList<>();

        q.offer(s);
        level[s.x][s.y] = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int k = 0; k < size; k++) {
                Point cur = q.poll();
                for(int d = 0; d < 4; d++) {
                    int i = cur.x + delta[d], j = cur.y + delta[d + 1];
                    if(i < 0 || i >= m || j < 0 || j >= n) continue;
                    if(grid[i][j] == 0 && level[i][j] == 0) {
                        level[i][j] = level[cur.x][cur.y] + 1;
                        count[i][j]++;
                        distance[i][j] += level[i][j];
                        q.offer(new Point(i, j));
                    }
                }
            }
        }
    }
}
//version 2: BFS with change to grid
public class Solution {

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int total = 0, m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, new Point(i, j), distance, total);
                    total--;//用负数，来代表进行到第几个房子bfs，避免与0，1，2重复
                }
            }
        }

        int res = -1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == total) {//表明所有房子都能到
                    if(res == -1) {
                        res = distance[i][j];
                    } else {
                        res = Math.min(res, distance[i][j]);
                    }
                }
            }
        }

        return res;
    }

    public void bfs(int[][] grid, Point s, int[][] distance, int count) {
        int[] delta = {1, 0, -1, 0, 1};
        int m = grid.length, n = grid[0].length;
        int[][] level = new int[m][n];
        Queue<Point> q = new LinkedList<>();

        q.offer(s);
        level[s.x][s.y] = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int k = 0; k < size; k++) {
                Point cur = q.poll();
                for(int d = 0; d < 4; d++) {
                    int i = cur.x + delta[d], j = cur.y + delta[d + 1];
                    if(i < 0 || i >= m || j < 0 || j >= n) continue;
                    if(grid[i][j] == count && level[i][j] == 0) {//grid[i][j] == count代表，在之前的房子都能到这个点，则继续更新；如果之前有房子到不了，则不用继续更新了。
                        grid[i][j] = count - 1;
                        level[i][j] = level[cur.x][cur.y] + 1;
                        distance[i][j] += level[i][j];
                        q.offer(new Point(i, j));
                    }
                }
            }
        }
    }
}
