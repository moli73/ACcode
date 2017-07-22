//better code
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] delta = {-1, 0, 1, 0, -1};

        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(Arrays.equals(cur, destination)) {
                return true;
            }

            for(int k = 0; k < 4; k++) {
                int i = cur[0], j = cur[1];
                while(i + delta[k] >= 0 && i + delta[k] < m &&
                      j + delta[k + 1] >= 0 && j + delta[k + 1] < n &&
                      maze[i + delta[k]][j + delta[k + 1]] == 0) {
                    i += delta[k];
                    j += delta[k + 1];
                }

                if(!visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new int[] {i, j});
                }
            }
        }

        return false;
    }
}
//first version
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];

        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(Arrays.equals(cur, destination)) {
                return true;
            }

            int i = cur[0], j = cur[1];
            //up
            while(i < m && maze[i][j] == 0) {
                i++;
            }
            if(!visited[i - 1][j]) {
                visited[i - 1][j] = true;
                q.offer(new int[] {i - 1, j});
            }
            //down
            i = cur[0];
            while(i >= 0 && maze[i][j] == 0) {
                i--;
            }
            if(!visited[i + 1][j]) {
                visited[i + 1][j] = true;
                q.offer(new int[] {i + 1, j});
            }
            //right
            i = cur[0];
            while(j < n && maze[i][j] == 0) {
                j++;
            }
            if(!visited[i][j - 1]) {
                visited[i][j - 1] = true;
                q.offer(new int[] {i, j - 1});
            }
            //left
            j = cur[1];
            while(j >= 0 && maze[i][j] == 0) {
                j--;
            }
            if(!visited[i][j + 1]) {
                visited[i][j + 1] = true;
                q.offer(new int[] {i, j + 1});
            }
        }

        return false;
    }
}
