//version 1: BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        HashSet<String> words = new HashSet<String>(wordList);

        if(words.contains(beginWord)){
             words.remove(beginWord);
        }


        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            res++;

            for(int k = 0; k < size; ++k){
                String word = q.poll();
                if(word.equals(endWord)){return res;}

                for(int i = 0; i < word.length(); ++i){
                    for(int j = 0; j < 26; ++j){
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, (char)('a' + j));
                        String next = new String(sb.toString());

                        if(!next.equals(word)){//this condition could delete, it always true when
                            if(words.contains(next)){//this is true, it cannot be same with word
                                words.remove(next);
                                q.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}

//mock version
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> graph = new HashMap<>();

        dict.add(beginWord);
        for(String word : dict) {
            graph.put(word, getAdj(word, dict));
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        dict.remove(beginWord);
        int level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i = 0; i < size; i++) {
                String node = q.poll();
                if(node.equals(endWord)) {
                      return level;
                }
                for(String adj : graph.get(node)) {
                      if(!dict.contains(adj)) continue;
                      dict.remove(adj);
                      q.offer(adj);
                }
            }
        }
        return 0;
    }

    public List<String> getAdj(String word, Set<String> dict) {
        List<String> adjs = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                StringBuffer sb = new StringBuffer(word);
                if(c == word.charAt(i)) continue;
                sb.setCharAt(i, c);
                if(dict.contains(sb.toString())) {
                    adjs.add(sb.toString());
                }
            }
        }
        return adjs;
    }
}
