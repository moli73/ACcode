public class Solution {
    private int[] father = null;
    private int count;
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

    public int findCircleNum(int[][] M) {
        int n = M.length;
        father = new int[n];
        for(int i = 0; i < n; i++) {
            father[i] = i;
        }
        count = n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }
}
