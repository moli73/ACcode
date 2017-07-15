public class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                helper(graph, i, visited);
            }
        }

        return count;
    }

    public void helper(List<List<Integer>> graph, int s, boolean[] visited) {
        if(visited[s]) {
            return;
        } else {
            visited[s] = true;
        }

        for(int adj : graph.get(s)) {
            helper(graph, adj, visited);
        }
    }
}
