//version 1 : TLE
public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> words = new HashSet<String>(wordList);
        words.remove(beginWord);

        List<String> path = new ArrayList<String>();
        path.add(beginWord);

        Queue<List<String>> q = new LinkedList<List<String>>();//tricky is to stall the list into queue
        q.offer(path);

        while(!q.isEmpty()){
            if(res.size() != 0) break;//once find the anwser, no need to search

            int size = q.size();
            Set<String> preWords = new HashSet<String>(words);//to record the fromer set

            for(int k = 0; k < size; ++k){
                List<String> cur = q.poll();

                String word = cur.get(cur.size() - 1);
                if(endWord.equals(word)){
                    res.add(cur);
                    continue;
                }

                for(String next : getNext(word)){
                    if(preWords.contains(next)){//use former set to check the exsitence
                            words.remove(next);
                            List<String> nextPath = new ArrayList<String>(cur);
                            nextPath.add(next);
                            q.offer(nextPath);
                    }
                }
            }
        }
        return res;
    }

    public List<String> getNext(String word){
        List<String> next = new ArrayList<String>();
        for(int i = 0; i < word.length(); ++i){
            for(int j = 0; j < 26; ++j){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, (char)('a' + j));
                next.add(sb.toString());
            }
        }
        return next;
    }
}
//version 2: BFS + DFS
//DFS part：用的类似与普通DFS的方式，类topological sort
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
        visited = new HashSet<>();

        if(min == -1) { return res; }

        helper(res, comb, graph, path, visited, beginWord, endWord, 0, min);

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, Map<String, List<String>> graph, Map<String, Integer> path,
                       Set<String> visited, String word, String endWord, int level, int min) {


        if(visited.contains(word) || !path.containsKey(word) || path.get(word) + level > min) {
            return;
        }

        visited.add(word);
        comb.add(word);

        if(word.equals(endWord)) {
            res.add(new ArrayList<>(comb));
        }

        for(String adj : graph.get(word)) {
            helper(res, comb, graph, path, visited, adj, endWord, level + 1, min);
        }
        visited.remove(word);
        comb.remove(comb.size() - 1);//结束函数时，注意回溯即是recover
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
//DFS part:更像backtracking的样子
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
        visited = new HashSet<>();

        if(min == -1) { return res; }

        comb.add(beginWord);//需要提前处理beginWord（root也需要记录），所以level起始值为1
        visited.add(beginWord);
        helper(res, comb, graph, path, visited, beginWord, endWord, 1, min);

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, Map<String, List<String>> graph, Map<String, Integer> path,
                       Set<String> visited, String word, String endWord, int level, int min) {
        if(word.equals(endWord)) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for(String adj : graph.get(word)) {
            if(visited.contains(adj) || !path.containsKey(adj) || path.get(adj) + level > min) {
                continue;
            }
            visited.add(adj);
            comb.add(adj);
            helper(res, comb, graph, path, visited, adj, endWord, level + 1, min);
            comb.remove(comb.size() - 1);
            visited.remove(adj);
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
//DFS部分是混搭：说明终止条件所放的位置比较灵活
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
        visited = new HashSet<>();

        if(min == -1) { return res; }

        comb.add(beginWord);
        helper(res, comb, graph, path, visited, beginWord, endWord, 0, min);

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, Map<String, List<String>> graph, Map<String, Integer> path,
                       Set<String> visited, String word, String endWord, int level, int min) {
        if(word.equals(endWord)) {
            res.add(new ArrayList<>(comb));
            return;
        }

        if(visited.contains(word) || !path.containsKey(word) || path.get(word) + level > min) {
            return;
        }

        visited.add(word);

        for(String adj : graph.get(word)) {
            comb.add(adj);
            helper(res, comb, graph, path, visited, adj, endWord, level + 1, min);
            comb.remove(comb.size() - 1);
        }

        visited.remove(word);
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
