//second time
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> pq = new PriorityQueue<int[]>(m, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        for(int i = 0; i < m; i++) {
            pq.offer(new int[] {matrix[i][0], i, 0});
        }
        
        for(int i = 0; i < k - 1; i++) {
            int[] item = pq.poll();
            int x = item[1];
            int y = item[2] + 1;
            if(y < n) {
                pq.offer(new int[] {matrix[x][y], x, y});
            }
        }
        int[] item = pq.poll();
        return item[0];
    }
}

//jiuzhang version
public class Solution {
    class Item {
        int i;
        int j;
        int value;
        Item(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    public Comparator<Item> cmp = new Comparator<Item>() {
        public int compare(Item a, Item b) {
            return a.value - b.value;
        }
    };

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, res = 0;
        Queue<Item> pq = new PriorityQueue<Item>(11, cmp);
        int[][] delta = {{1, 0}, {0, 1}};
        boolean[][] visited = new boolean[m][n];

        pq.offer(new Item(0, 0, matrix[0][0]));
        visited[0][0] = true;

        while(k > 0) {
            Item cur = pq.poll();
            res = cur.value;
            k--;

            for(int t = 0; t < 2; t++) {
                int i = cur.i + delta[t][0], j = cur.j + delta[t][1];

                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;

                visited[i][j] = true;
                pq.offer(new Item(i, j, matrix[i][j]));
            }
        }

        return res;
    }
}
