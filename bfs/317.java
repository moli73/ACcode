//version 1: BFS without change the grid
public class Solution {

    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int total = 0, m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];//记录每个空格到每个house的距离累加和
        int[][] count = new int[m][n];//记录每个空格能够到达的house数量

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    total++;//记录house的个数
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
        int[][] level = new int[m][n];//记录shortest距离，同时充当visited数组的功能
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


class Solution {
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int[][] count = new int[m][n];

        int house = 0;

        int[] delta = {1,0,-1,0,1};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    house++;//count total number of house
                    boolean[][] visited = new boolean[m][n];

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[] {i, j});
                    // visited[i][j] = true;
                    int d = 0;

                    while(!q.isEmpty()) {
                        int size = q.size();
                        d++;
                        for(int k = 0; k < size; k++) {
                            int[] cur = q.poll();
                            for(int t = 0; t < 4; t++) {
                                int x = cur[0] + delta[t];
                                int y = cur[1] + delta[t + 1];
                                if(x < 0 || x >= m || y < 0 || y >= n) continue;
                                if(visited[x][y]) continue;
                                if(grid[x][y] != 0) continue;

                                visited[x][y] = true;
                                res[x][y] += d;//accumulate distance
                                count[x][y]++;//add one house
                                q.offer(new int[] {x, y});
                            }
                        }
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && count[i][j] == house) {
                    min = Math.min(res[i][j], min);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}

/*
step1:bfs all building to all empty position distance
每个building，建立一个temp matrix，记录距离。第一次bfs到的cell就累加对应路径的res matrix，同时建立一个count matrix,记录是否所有building都能够到达这个cell

step2:accumulate the empty position to all building's distance

step3:traverse all to find the minimum total distance



*/
