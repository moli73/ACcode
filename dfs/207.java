//version 1: use ordering label checking --> 用的coursera上的讲的方法
public class Solution {
    private int order;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] labels = new int[numCourses];

        Map<Integer, List<Integer>> hash = new HashMap<>();
        for(int[] pre : prerequisites) {
            if(hash.containsKey(pre[1])) {
                hash.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> adjs = new ArrayList<>();
                adjs.add(pre[0]);
                hash.put(pre[1], adjs);
            }
        }

        order = numCourses;

        for(int i = 0; i < numCourses; i++) {
            if(labels[i] != 0) continue;

            helper(labels, i, hash);
        }

        for(int[] pre : prerequisites) {
            if(labels[pre[0]] < labels[pre[1]]) {
                return false;
            }
        }

        return true;
    }

    public void helper(int[] labels, int s, Map<Integer, List<Integer>> hash) {
        labels[s] = -1;
        if(hash.containsKey(s)) {
            for(int adj : hash.get(s)) {
                if(labels[adj] != 0) continue;
                helper(labels, adj, hash);
            }
        }


        labels[s] = order;
        order--;
    }
}

//version 2: use tri-status record check
public class Solution {
    private int order;
    private boolean res = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] labels = new int[numCourses];

        Map<Integer, List<Integer>> hash = new HashMap<>();
        for(int[] pre : prerequisites) {
            if(hash.containsKey(pre[1])) {
                hash.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> adjs = new ArrayList<>();
                adjs.add(pre[0]);
                hash.put(pre[1], adjs);
            }
        }

        order = numCourses;

        for(int i = 0; i < numCourses; i++) {
            if(labels[i] != 0) continue;

            helper(labels, i, hash);
        }

        return res;
    }

    public void helper(int[] labels, int s, Map<Integer, List<Integer>> hash) {
        if(labels[s] == -1){//-1 presents visited
            res = false;
            return;
        }
        if(labels[s] != 0) {//0 presents unvisited
            return;
        }

        labels[s] = -1;
        if(hash.containsKey(s)) {
            for(int adj : hash.get(s)) {
                helper(labels, adj, hash);
            }
        }


        labels[s] = order;// order > 0 presents finished
        order--;
    }
}

//version 3: better tri-status check code using divide and conquer
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];//tricky
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for(int[] pre : prerequisites) {
            graph[pre[1]].add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses],
        boolean[] finished = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if(!helper(graph, visited, finished, i)){
                return false;
            }
        }

        return true;
    }

    public boolean helper(ArrayList[] graph, boolean[] visited, boolean[] finished, int s) {
        if(finished[s]) {
            return true;
        } else if(visited[s]) {
            return false;
        } else {
            visited[s] = true;
        }

        for(int i=0; i<graph[s].size();i++){
            int adj = (int)graph[s].get(i);//tricky
            if(!helper(graph, visited, finished, adj)){
                return false;
            }
        }

        finished[s] = true;
        //visited[s] = false;
        return true;
    }
}
