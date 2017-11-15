public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {//边数一定是node数减1，所以从一个点（任意选为0）开始，遍历完所有边，检测是否多优点都遍历过
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[n];
        helper(state, 0, graph);

        for(int cur : state) {//检测是否所有node被遍历过
            if(cur == 0) {
                return false;
            }
        }

        return true;
    }

    public void helper(int[] state, int s, List<List<Integer>> graph) {
        if(state[s] != 0) {
            return;
        } else {
            state[s] = 1;
        }
        for(int adj : graph.get(s)) {
            helper(state, adj, graph);
        }
    }
}
