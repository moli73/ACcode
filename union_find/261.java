class Solution {
    private int[] father;
    private int count;

    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    private boolean union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a == root_b) {
            return false;
        } else {
            father[root_a] = root_b;
            count--;
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        count = n;
        father = new int[n];

        for(int i = 0; i < n; i++) {
            father[i] = i;
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v)) {
                return false;
            }
        }

        return count == 1;
    }
}
