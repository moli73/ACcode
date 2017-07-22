public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> all = new HashSet<>();
        for(String word : words) {
            for(char c : word.toCharArray()) {
                all.add(c);
            }
        }

        Map<Character,Integer> indegree = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        int count = 0;
        for(Character s : all) {
            graph.put(s, new ArrayList<>());
            indegree.put(s, 0);
        }

        for(int k = 0; k < words.length - 1; k++) {
            int i = 0, j = 0;
            String s1 = words[k], s2 = words[k + 1];
            while(i < s1.length() && j < s2.length()) {
                if(s1.charAt(i) != s2.charAt(j)) break;
                i++; j++;
            }
            if(i == s1.length() || j == s2.length()) {
                continue;
            } else {
                char c1 = s1.charAt(i), c2 = s2.charAt(j);
                graph.get(c1).add(c2);
                indegree.put(c2, indegree.get(c2) + 1);
                count++;
            }
        }

        Queue<Character> q = new LinkedList<>();
        for(Character s : all) {
            if(indegree.get(s) == 0) {
                q.offer(s);
            }
        }

        StringBuffer res = new StringBuffer();
        while(!q.isEmpty()) {
            Character s = q.poll();
            res.append(s);

            for(Character adj : graph.get(s)) {
                indegree.put(adj, indegree.get(adj) - 1);
                count--;
                if(indegree.get(adj) == 0) {
                    q.offer(adj);
                }
            }
        }

        return count == 0 ? res.toString() : "";
    }
}
