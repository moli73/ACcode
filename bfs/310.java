//version 4 is the best solution
//version 1: n times BFS, TLE
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> res = new ArrayList<>();
        int max = Integer.MAX_VALUE;
        for(int s = 0; s < n; s++) {
            int level = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n];

            visited[s] = true;
            q.offer(s);

            while(!q.isEmpty()) {
                int size = q.size();
                level++;

                for(int i = 0; i < size; i++) {
                    int cur = q.poll();
                    for(int adj : graph.get(cur)) {
                        if(!visited[adj]) {
                            visited[adj] = true;
                            q.offer(adj);
                        }
                    }
                }
            }

            if(level < max) {
                max = level;
                res.clear();
                res.add(s);
            } else if(level == max) {
                res.add(s);
            }
        }

        return res;
    }
}
//version 2: BFS + DFS, but Stack Overflow
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //BFS:
        int last = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();

                for(int adj : graph.get(last)) {
                    if(!visited[adj]) {
                        visited[adj] = true;
                        q.offer(adj);
                    }
                }
            }
        }
        //DFS:
        List<Integer> path = new ArrayList<>();
        visited = new boolean[n];

        helper(graph, path, new ArrayList<Integer>(), visited, last);
        //Get the result
        List<Integer> res = new ArrayList<>();
        if(path.size() % 2 == 1) {
            res.add(path.get(path.size() / 2));
        } else {
            res.add(path.get(path.size() / 2));
            res.add(path.get(path.size() / 2 - 1));
        }

        return res;
    }

    public void helper(List<List<Integer>> graph, List<Integer> path, List<Integer> comb, boolean[] visited, int s) {
        if(visited[s]) {
            return;
        }
        visited[s] = true;
        comb.add(s);
        if(comb.size() > path.size()) {
            path.clear();
            path.addAll(comb);
        }

        for(int adj : graph.get(s)) {
            helper(graph, path, comb, visited, adj);
        }

        comb.remove(comb.size() - 1);
    }
}

//version 3: 3 times BFS
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //to find the end node of the main path of tree
        int last = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();

                for(int adj : graph.get(last)) {
                    if(!visited[adj]) {
                        visited[adj] = true;
                        q.offer(adj);
                    }
                }
            }
        }
        //to find the longest path of tree
        int length = 1;
        int[] level = new int[n];

        level[last] = 1;
        q.offer(last);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();
                length = level[last];

                for(int adj : graph.get(last)) {
                    if(level[adj] == 0) {
                        level[adj] = level[last] + 1;
                        q.offer(adj);
                    }
                }
            }
        }
        //to check the main path node of trees
        int[] rLevel = new int[n];

        rLevel[last] = 1;
        q.offer(last);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();

                for(int adj : graph.get(last)) {
                    if(rLevel[adj] == 0) {
                        rLevel[adj] = rLevel[last] + 1;
                        if(rLevel[adj] + level[adj] != length + 1) {
                            level[adj] = -1;
                        }
                        q.offer(adj);
                    }
                }
            }
        }

        List<Integer> res =  new ArrayList<>();

        if(length % 2 == 1) {
            for(int i = 0; i < n; i++) {
                if(level[i] == (length + 1) / 2) {
                    res.add(i);
                }
            }
        } else {
            for(int i = 0; i < n; i++) {
                if(level[i] == length / 2 || level[i] == length / 2 + 1) {
                    res.add(i);
                }
            }
        }

        return res;
    }
}
//version 4: best code, use twice BFS + pre array
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //find one end-node of the longest path of tree
        int last = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[0] = true;
        q.offer(0);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();

                for(int adj : graph.get(last)) {
                    if(!visited[adj]) {
                        visited[adj] = true;
                        q.offer(adj);
                    }
                }
            }
        }
        //to find the longest path of the tree
        int[] pre = new int[n];
        visited = new boolean[n];

        visited[last] = true;
        pre[last] = -1;
        q.offer(last);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                last = q.poll();

                for(int adj : graph.get(last)) {
                    if(!visited[adj]) {
                        visited[adj] = true;
                        pre[adj] = last;//the last node always the deepest node of the graph
                        q.offer(adj);
                    }
                }
            }
        }
        //find out the nodes of longest path of the tree by using pre
        List<Integer> list = new ArrayList<>();
        while(last != -1) {
            list.add(last);
            last = pre[last];
        }
        return list.size() % 2 == 1 ?
                Arrays.asList(list.get(list.size() / 2)) :
                Arrays.asList(list.get(list.size() / 2 - 1), list.get(list.size() / 2));//tricky
    }
}
