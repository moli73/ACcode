public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[256];
        int i = 0, j = 0;
        int res = 0, count = 0;
        for(i = 0; i < s.length(); i++) {
            while(j < s.length() && count <= 2) {
                if(map[s.charAt(j)] == 0) {
                    count++;
                }
                map[s.charAt(j)]++;
                j++;
            }

            if(count <= 2) {
                res = Math.max(res, j - i);
            } else {
                res = Math.max(res, j - i - 1);
            }

            map[s.charAt(i)]--;
            if(map[s.charAt(i)] == 0) {
                count--;
            }
        }

        return res;
    }
}
