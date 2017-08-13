public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), count = words.length;
        if(n == 0 || count == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        int wl = words[0].length();
        for(int k = 0; k < wl; k++) {
            int i = k, j = k;
            for(i = k; i <= n - wl; i += wl) {
                if(j < i) {
                    j = i;
                }

                while(j <= n - wl) {
                    String sub = s.substring(j, j + wl);

                    if(map.containsKey(sub) && map.get(sub) > 0) {
                        count--;
                        map.put(sub, map.get(sub) - 1);
                        j += wl;
                    } else {
                        break;
                    }
                }
                if(count == 0) {
                    res.add(i);
                }
                String temp = s.substring(i, i + wl);
                if(map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    count++;
                }
            }
        }
        return res;
    }
}
