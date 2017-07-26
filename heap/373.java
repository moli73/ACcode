public class Solution {
    class Item {
        int i;
        int j;
        int val;
        Item(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }

    public Comparator<Item> cmp = new Comparator<Item>() {
        public int compare(Item a, Item b) {
            return a.val - b.val;
        }
    };

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        if(m == 0 || n == 0) {
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[m][n];
        Queue<Item> pq = new PriorityQueue<>(k, cmp);
        List<int[]> res = new ArrayList<>();
        int[][] d = {{1, 0}, {0, 1}};

        pq.offer(new Item(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;

        while(k > 0 && !pq.isEmpty()) {
            Item cur = pq.poll();
            k--;
            res.add(new int[] {nums1[cur.i], nums2[cur.j]});

            for(int t = 0; t < 2; t++) {
                int i = cur.i + d[t][0], j = cur.j + d[t][1];

                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;

                visited[i][j] = true;
                pq.offer(new Item(i, j, nums1[i] + nums2[j]));
            }
        }

        return res;
    }
}
