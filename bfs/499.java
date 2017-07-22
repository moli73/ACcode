public class Solution {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int[][] length = new int[m][n];

        String[][] path = new String[m][n];
        for(String[] items : path)
            Arrays.fill(items, new String());

        Queue<int[]> q = new LinkedList<>();

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] step = {'d', 'l', 'r', 'u'};

        q.offer(ball);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(Arrays.equals(cur, hole)) continue;

            for(int k = 0; k < 4; k++) {

                int i = cur[0], j = cur[1];
                int count = 0;
                while((i != hole[0] || j != hole[1]) && i + dx[k] >= 0 && i + dx[k] < m &&
                        j + dy[k] >= 0 && j + dy[k] < n &&
                            maze[i + dx[k]][j + dy[k]] == 0) {
                    count++; i += dx[k]; j += dy[k];
                }

                if((i != ball[0] || j != ball[1]) && //不能是起点
                    (length[i][j] == 0 || //第一次访问
                        length[i][j] > length[cur[0]][cur[1]] + count || //length更小，要更新
                        (length[i][j] == length[cur[0]][cur[1]] + count && path[i][j].compareTo(path[cur[0]][cur[1]] + step[k]) > 0))) {
                        //length相同，但是字典序更小，也要更新
                    path[i][j] = path[cur[0]][cur[1]] + step[k];
                    length[i][j] = length[cur[0]][cur[1]] + count;

                    q.offer(new int[] {i, j});
                }
            }
        }

        return path[hole[0]][hole[1]].length() == 0 ? "impossible" : path[hole[0]][hole[1]];
    }
}
