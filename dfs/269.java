public class Solution {
    private String res;

    public String alienOrder(String[] words) {
        Map<Integer, List<Integer>> graph = makeGraph(words);

        boolean[] visited = new boolean[26];
        boolean[] finished = new boolean[26];
        res = new String();

        for(Integer s : graph.keySet()) {
            if(!helper(graph, s, visited, finished)) {
                return new String();
            }
        }

        return res;
    }

    public Map<Integer, List<Integer>> makeGraph(String[] words) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Character> set = new HashSet<>();
        //get all chars show in these dictionary
        for(String word : words) {
            for(char c : word.toCharArray()) {
                set.add(c);
            }
        }

        //initial the adjacent list
        for(Character c : set) {
            graph.put(c - 'a', new ArrayList<Integer>());
        }

        //construct the adjacent list
        for(int i = 0; i < words.length - 1; i++) {
            int[] edge = getEdge(words[i], words[i + 1]);
            if(edge != null) {
                if(!graph.get(edge[0]).contains(edge[1])) {
                    graph.get(edge[0]).add(edge[1]);
                }
            }
        }

        return graph;
    }

    public int[] getEdge(String s1, String s2) {
        int[] edge = new int[2];
        int i = 0, j = 0;
        while(i < s1.length() && j < s2.length()) {
            if(s1.charAt(i) != s2.charAt(j)) break;
            i++; j++;
        }

        if(i == s1.length() || j == s2.length()) {
            edge = null;
        } else {
            edge[0] = s1.charAt(i) - 'a';
            edge[1] = s2.charAt(j) - 'a';
        }

        return edge;
    }

    public boolean helper(Map<Integer, List<Integer>> graph, int s, boolean[] visited, boolean[] finished) {
        if(finished[s]) {
            return true;
        } else if(visited[s]) {
            return false;
        } else {
            visited[s] = true;
        }

        for(Integer adj : graph.get(s)) {
            if(!helper(graph, adj, visited, finished)) {
                return false;
            }
        }

        visited[s] = false;
        finished[s] = true;
        res = (char)(s + 'a') + res;
        return true;
    }

}
