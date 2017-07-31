public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map1 = new HashMap<>();
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        if(words.length == 0) {
            return res;
        }
        int l = words[0].length();
        int count = words.length;

        for(String str : words) {
            if(map1.containsKey(str)) {
                map1.put(str, map1.get(str) + 1);
            } else {
                map1.put(str, 1);
            }
        }

        for(i = 0; i + count * l <= s.length(); i++) {
            Map<String, Integer> map = new HashMap<String, Integer>(map1);
            j = i;
            while(j < s.length() && count != 0) {
                String sub = s.substring(j, j + l);
                if(map.containsKey(sub) && map.get(sub) > 0) {
                    j += l;
                    map.put(sub, map.get(sub) - 1);
                    count--;
                } else {
                    break;
                }
            }

            if(count == 0) {
                res.add(i);
            }
            count = words.length;
        }

        return res;
    }
}
