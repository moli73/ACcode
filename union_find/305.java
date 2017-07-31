public class Solution {
    private int[] father = null;
    private int count = 0;
    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
            count--;
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        father = new int[m * n];
        boolean[] isLand = new boolean[m * n];
        for(int i = 0; i < m * n; i++) {
            father[i] = i;
        }
        List<Integer> res = new ArrayList<>();
        int[] d = {-1, 0, 1, 0, -1};
        for(int[] pos : positions) {
            isLand[n * pos[0] + pos[1]] = true;
            count++;

            for(int k = 0; k < 4; k++) {
                int i = pos[0] + d[k], j = pos[1] + d[k + 1];
                if(i < 0 || i >= m || j < 0 || j >= n || !isLand[n * i + j]) continue;

                union(n * pos[0] + pos[1], n * i + j);
            }
            res.add(count);
        }
        return res;
    }
}
