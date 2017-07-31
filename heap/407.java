public class Solution {
    class Cell {
        int i, j, val;
        Cell(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if(heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length, res = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Cell> pq = new PriorityQueue<>(11, new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.val - b.val;
            }
        });

        for(int i = 0; i < m; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][0] = true;
            pq.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][n - 1] = true;
        }
        for(int j = 0; j < n; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            visited[0][j] = true;
            pq.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[m - 1][j] = true;
        }
        int[] d = {-1, 0, 1, 0, -1};

        while(!pq.isEmpty()) {
            Cell cur = pq.poll();
            for(int k = 0; k < 4; k++) {
                int i = cur.i + d[k], j = cur.j + d[k + 1];
                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;
                visited[i][j] = true;
                if(cur.val > heightMap[i][j]) {
                    res += cur.val - heightMap[i][j];
                    pq.offer(new Cell(i, j, cur.val));
                } else {
                    pq.offer(new Cell(i, j, heightMap[i][j]));
                }
            }
        }

        return res;
    }
}
