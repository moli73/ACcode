//final version
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = org.length;
        int[] indegree = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        boolean empty = true;

        for(List<Integer> seq : seqs) {
            if(seq.size() == 0) continue;
            empty = false;
            int u = seq.get(0), v = seq.get(0);
            if(u < 0 || u > n) return false;

            for(int i = 1; i < seq.size(); i++) {
                u = seq.get(i - 1);
                v = seq.get(i);

                if(v < 0 || v > n) return false;

                if(!graph.get(u).contains(v)) {
                    graph.get(u).add(v);
                    indegree[v]++;
                }
            }
        }

        if(empty) return false;

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 1; i< n + 1; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(q.size() == 1) {
            int cur = q.poll();
            count++;

            for(int adj : graph.get(cur)) {
                indegree[adj]--;
                if(indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
        }

        return count == n;
    }
}

//better code
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        boolean empty = true;

        for(List<Integer> seq : seqs) {
            // if(seq.size() >= 1) {
            //     if((seq.get(0) < 1 || seq.get(0) > n)) {
            //         return false;
            //     } else {
            //         if(indegree[seq.get(0)] == -1) {
            //             indegree[seq.get(0)] = 0;
            //         }
            //     }
            // }//只有一个数的sequence特殊处理，并对第一个数单独处理。（ 第一个数不用单独处理，入度肯定是0，只需要处理一个数时的第一个数情况，要判断越界情况）
            if(seq.size() == 0) continue;
            else {
                empty = false;
            }

            if(seq.get(0) < 1 || seq.get(0) > n) {
                return false;//tricky, 每次第一个数需要单独判断越界，这样后面只需对v判断越界。同时也包括了只有一个数的seq判断
            }

            for(int i = 1; i < seq.size(); i++) {
                int u = seq.get(i - 1), v = seq.get(i);
                if(v < 1 || v > n) {
                    return false;
                }

                if(!graph.get(u).contains(v)) {
                    graph.get(u).add(v);
                    if(indegree[v] == -1) indegree[v] = 0;
                    indegree[v]++;
                }
            }
        }

        if(empty) return false;//for [1], [[], []]

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                count++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            if(q.size() != 1) {
                return false;
            }

            int cur = q.poll();

            for(int adj : graph.get(cur)) {
                indegree[adj]--;

                if(indegree[adj] == 0) {
                    count++;
                    q.offer(adj);
                }
            }
        }

        return count == n;
    }
}
//first time
public class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            indegree[i] = -1;//-1代表此数在seqs中还没有出现过
        }

        for(List<Integer> seq : seqs) {
            if(seq.size() >= 1) {
                if((seq.get(0) < 1 || seq.get(0) > n)) {
                    return false;
                } else {
                    if(indegree[seq.get(0)] == -1) {
                        indegree[seq.get(0)] = 0;
                    }
                }
            }//只有一个数的sequence特殊处理，并对第一个数单独处理。
            for(int i = 1; i < seq.size(); i++) {
                int u = seq.get(i - 1), v = seq.get(i);
                if(u < 1 || u > n || v < 1 || v > n) {
                    return false;
                }

                if(!graph.get(u).contains(v)) {
                    graph.get(u).add(v);
                    if(indegree[v] == -1) indegree[v] = 0;
                    indegree[v]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == -1) {
                return false;
            }
            if(indegree[i] == 0) {
                count++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            if(q.size() != 1) {
                return false;
            }

            int cur = q.poll();

            for(int adj : graph.get(cur)) {
                indegree[adj]--;

                if(indegree[adj] == 0) {
                    count++;
                    q.offer(adj);
                }
            }
        }

        return count == n;
    }
}
