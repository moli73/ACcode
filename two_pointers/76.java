//Leetcode version
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        int start = 0, len = s.length() + 1;
        int i = 0, j = 0;
        for(i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            if(map.get(c) > 0) {
                count--;
            }
            map.put(c, map.get(c) - 1);
            while(count == 0) {
                if(j - i + 1 < len) {
                    start = i;
                    len = j - i + 1;
                }
                char temp = s.charAt(i);
                map.put(temp, map.get(temp) + 1);
                if(map.get(temp) > 0) {
                    count++;
                }
                i++;
            }
        }
        return len == s.length() + 1 ? new String() : s.substring(start, start + len);
    }
}

//JiuZhang version
public class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int i = 0, j = 0, start = 0, len = 0, count = t.length();
        for(i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        for(i = 0; i < s.length(); i++) {
            while(j < s.length() && count != 0) {
                if(map[s.charAt(j)] > 0) {
                    count--;
                }
                map[s.charAt(j)]--;
                j++;
            }
            if(count == 0 && (len == 0 || len > j - i)) {
                start = i;
                len = j - i;
            }
            map[s.charAt(i)]++;
            if(map[s.charAt(i)] > 0) {
                count++;
            }
        }

        return s.substring(start, start + len);
    }
}
