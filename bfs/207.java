public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);

            indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int s = q.poll();
            for(int adj : graph.get(s)) {
                indegree[adj]--;
                count++;
                if(indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        return count == prerequisites.length;
    }
}
