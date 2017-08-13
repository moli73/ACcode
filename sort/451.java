public class Solution {
    public String frequencySort(String s) {
        char[] str = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(char c : str) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
            max = Math.max(max, map.get(c));
        }
        StringBuilder[] buckets = new StringBuilder[max + 1];
        for(Character c : map.keySet()) {
            int count = map.get(c);
            if(buckets[count] == null) {
                buckets[count] = new StringBuilder();
            }
            for(int i = 0; i < count; i++) {
                buckets[count].append(c);
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = max; i >= 0; i--) {
            if(buckets[i] != null) {
                res.append(buckets[i]);
            }
        }
        return res.toString();
    }
}
