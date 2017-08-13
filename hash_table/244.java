public class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(words[i], temp);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> pos1 = map.get(word1);
        List<Integer> pos2 = map.get(word2);
        int i = 0, j = 0;
        int res = Integer.MAX_VALUE;
        while(i < pos1.size() && j < pos2.size()) {
            if(pos1.get(i) < pos2.get(j)) {
                res = Math.min(res, pos2.get(j) - pos1.get(i));
                i++;
            } else {
                res = Math.min(res, pos1.get(i) - pos2.get(j));
                j++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
