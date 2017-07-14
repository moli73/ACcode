public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            if(!helper(graph, i, state, res)) {
                return new int[0];
            }
        }
        int[] out = new int[numCourses];
        for(int i = 0; i < out.length; i++) {
            out[i] = res.get(out.length - 1 - i);
        }
        return out;
    }

    public boolean helper(List<List<Integer>> graph, int s, int[] state, List<Integer> res) {
        if(state[s] == 2) {
            return true;
        } else if(state[s] == 1) {
            return false;
        } else {
            state[s] = 1;
        }

        for(int adj : graph.get(s)) {
            if(!helper(graph, adj, state, res)) {
                return false;
            }
        }

        res.add(s);
        state[s] = 2;
        return true;
    }
}public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];// 0 - not visited, 1 - visited, 2 - finished
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            if(!helper(graph, i, state, res)) {
                return new int[0];
            }
        }
        int[] out = new int[numCourses];
        for(int i = 0; i < out.length; i++) {
            out[i] = res.get(out.length - 1 - i);
        }
        return out;
    }

    public boolean helper(List<List<Integer>> graph, int s, int[] state, List<Integer> res) {
        if(state[s] == 2) {
            return true;
        } else if(state[s] == 1) {
            return false;
        } else {
            state[s] = 1;
        }

        for(int adj : graph.get(s)) {
            if(!helper(graph, adj, state, res)) {
                return false;
            }
        }

        res.add(s);
        state[s] = 2;
        return true;
    }
}
