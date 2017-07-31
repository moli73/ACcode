public class ConnectingGraph2 {
    private int[] father = null;
    private int[] count = null;
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        count = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            father[i] = i;
            count[i] = 1;
        }
    }

    public int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
            count[root_b] += count[root_a];
        }
    }

    public int query(int a) {
        // Write your code here
        return count[find(a)];
    }
}
