//version 1: DFS
public class Solution {
    private int count = 0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }

    public void helper(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);

    }
}
//version 2: BFS
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[] d = {-1, 0, 1, 0, -1};

        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    q.offer(new int[] {i, j});
                    grid[i][j] = '0';
                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for(int k = 0; k < 4; k++) {
                            int x = cur[0] + d[k];
                            int y = cur[1] + d[k + 1];
                            if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
                                continue;
                            }
                            grid[x][y] = '0';
                            q.offer(new int[] {x, y});
                        }
                    }
                }
            }
        }
        return count;
    }
}
//version 3: Union Find
class Solution {
    int[] father;
    int count, m, n;
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] d = {-1, 0, 1, 0, -1};
        m = grid.length;
        n = grid[0].length;
        father = new int[m * n];

        for(int i = 0; i < m * n; i++) {
            father[i] = i;
        }
        count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;//若是1，先占一个岛
                    for(int k = 0; k < 4; k++) {
                        int x = i + d[k];
                        int y = j + d[k + 1];
                        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
                        union(i * n + j, x * n + y);
                    }
                }
            }
        }
        return count;
    }

    private int find(int i) {
        if(father[i] == i) {
            return i;
        }
        return father[i] = find(father[i]);
    }

    private void union(int i, int j) {
        int root_a = find(i);
        int root_b = find(j);
        if(root_a != root_b) {
            count--;//若相接，又减一个岛
            father[root_a] = root_b;
        }
    }
}
