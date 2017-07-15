public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) {
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

        for(int cur : state) {
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
