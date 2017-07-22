public class Solution {
    public String res = new String();
    public int[][] delta = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    public char[] step = {'d', 'l', 'r', 'u'};

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] path = new int[maze.length][maze[0].length];
        helper(maze, path, ball, new StringBuffer(), hole, ball);
        return res.length() == 0 ? "impossible" : res;
    }

    public void helper(int[][] maze, int[][] path, int[] s, StringBuffer sb, int[] hole, int[] ball) {
        if(Arrays.equals(s, hole)) {
            res = sb.toString();
            return;
        }

        for(int k = 0; k < 4; k++) {
            int i = s[0], j = s[1],  count = 0;

            while((i != hole[0] || j != hole[1]) &&
                    i + delta[k][0] >= 0 && i + delta[k][0] < maze.length &&
                        j + delta[k][1] >= 0 && j + delta[k][1] < maze[0].length &&
                            maze[i + delta[k][0]][j + delta[k][1]] == 0) {
                i += delta[k][0]; j += delta[k][1]; count++;
            }

            if((i != ball[0] || j != ball[1]) &&
                    (path[i][j] == 0 || path[i][j] > path[s[0]][s[1]] + count)) {
                path[i][j] = path[s[0]][s[1]] + count;
                sb.append(step[k]);
                helper(maze, path, new int[] {i, j}, sb, hole, ball);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

}
