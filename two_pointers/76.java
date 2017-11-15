//Leetcode version
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        int count = t.length();
        int start = 0;
        int head = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c) > 0) {
                    count--;
                }
                map.put(c, map.get(c) - 1);
            }
            while(count == 0) {
                if(len == 0 || i - start + 1 < len) {
                    len = i - start + 1;
                    head = start;
                }
                if(map.containsKey(s.charAt(start))) {
                    map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                    if(map.get(s.charAt(start)) > 0) {
                        count++;
                    }
                }
                start++;
            }
        }
        return s.substring(head, head + len);
    }
}
//char array version
class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        for(int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int count = t.length();
        int start = 0;
        int head = 0;
        int len = 0;

        for(int i = 0; i < s.length(); i++) {
            if(map[s.charAt(i)] > 0) {
                count--;
            }
            map[s.charAt(i)]--;
            while(count == 0) {
                if(len == 0 || len > i - start + 1) {
                    head = start;
                    len = i - start + 1;
                }
                map[s.charAt(start)]++;
                if(map[s.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        return s.substring(head, head + len);
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
