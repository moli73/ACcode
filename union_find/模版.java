public class UnionFind {
    private int[] father = null;//使用前需要initialize，是每个元素father是本身，每个元素各成一个集合。
    public int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father[root_a] = root_b;
        }
    }
}
