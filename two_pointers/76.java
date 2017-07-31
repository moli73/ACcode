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
