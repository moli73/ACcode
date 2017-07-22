public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        List<String> comb = new ArrayList<String>();
        Set<String> dict = new HashSet<>(wordList);

        dict.add(beginWord);

        if(!dict.contains(endWord)) {
            return res;
        }

        //Build the graph
        graph.put(beginWord, getNeighbors(beginWord, dict));
        for(String word : wordList) {
            graph.put(word, getNeighbors(word, dict));
        }

        //BFS
        int min = -1;
        int level = 0;
        Map<String, Integer> path = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(endWord);
        path.put(endWord, level);
        visited.add(endWord);

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                for(String adj : graph.get(word)) {
                    if(!visited.contains(adj)) {
                        visited.add(adj);
                        path.put(adj, level);
                        q.offer(adj);

                        if(adj.equals(beginWord)) {
                            min = level;
                        }
                    }
                }
            }
            if(min != -1) break;
        }

        //DFS
        if(min == -1) { return res; }

        comb.add(beginWord);
        helper(res, comb, graph, path, beginWord, endWord, 1, min);

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, Map<String, List<String>> graph,
                       Map<String, Integer> path, String word, String endWord, int level, int min) {
        if(word.equals(endWord)) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for(String adj : graph.get(word)) {
            if(!path.containsKey(adj) || path.get(adj) + level > min) {//此条件也能够排除，已经遍历过的node
                continue;
            }
            comb.add(adj);
            helper(res, comb, graph, path, adj, endWord, level + 1, min);
            comb.remove(comb.size() - 1);
        }
    }

    public List<String> getNeighbors(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != word.charAt(i)) {
                    StringBuffer sb = new StringBuffer(word);
                    sb.setCharAt(i, c);
                    if(dict.contains(sb.toString())) {
                        res.add(sb.toString());
                    }
                }
            }
        }

        return res;
    }
}
