public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] path = new int[m][n];
        int[] delta = {-1, 0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int k = 0; k < 4; k++) {
                int  i = cur[0], j = cur[1], count = 0;
                while(i + delta[k] >= 0 && i + delta[k] < m &&
                        j + delta[k + 1] >= 0 && j + delta[k + 1] < n &&
                            maze[i + delta[k]][j + delta[k + 1]] == 0) {
                    i += delta[k];
                    j += delta[k + 1];
                    count++;
                }
                //if(i == start[0] && j == start[1]) continue;
                if((i != start[0] || j != start[1]) &&
                    (path[i][j] == 0 || path[i][j] > path[cur[0]][cur[1]] + count)) {
                    path[i][j] = path[cur[0]][cur[1]] + count;
                    q.offer(new int[] {i, j});
                }
            }
        }

        return path[destination[0]][destination[1]] == 0 ?
                -1 : path[destination[0]][destination[1]];
    }
}
