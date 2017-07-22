public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }

        int m = rooms.length, n = rooms[0].length;
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rooms[i][j] == 0) {
                    q.offer(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int k = 0; k < size; k++) {
                Point cur = q.poll();
                int i = cur.x;
                int j = cur.y;

                if(i > 0 && rooms[i - 1][j] > rooms[i][j] + 1) {
                    rooms[i - 1][j] = rooms[i][j] + 1;
                    q.offer(new Point(i - 1, j));
                }

                if(i < m - 1 && rooms[i + 1][j] > rooms[i][j] + 1) {
                    rooms[i + 1][j] = rooms[i][j] + 1;
                    q.offer(new Point(i + 1, j));
                }

                if(j > 0 && rooms[i][j - 1] > rooms[i][j] + 1) {
                    rooms[i][j - 1] = rooms[i][j] + 1;
                    q.offer(new Point(i, j - 1));
                }

                if(j < n - 1 && rooms[i][j + 1] > rooms[i][j] + 1) {
                    rooms[i][j + 1] = rooms[i][j] + 1;
                    q.offer(new Point(i, j + 1));
                }
            }
        }
    }
}
