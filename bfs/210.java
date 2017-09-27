class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>();
        int n = numCourses;

        for(int i = 0; i < n; i++) {
            adjs.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adjs.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] res = new int[n];
        int index = n - 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            res[index--] = cur;
            for(int adj : adjs.get(cur)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        if(index < 0) {
            return res;
        } else {
            return new int[]{};
        }
    }
}
