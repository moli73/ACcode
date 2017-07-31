public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int i = 0, j = 0, res = 0, count = 0;
        for(i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                if(map[s.charAt(j)] == 0) {
                    if(count == k) {
                        break;
                    }
                    count++;
                }
                map[s.charAt(j++)]++;
            }
            res = Math.max(res, j - i);
            if(--map[s.charAt(i)] == 0) {
                count--;
            }
        }
        return res;
    }
}
