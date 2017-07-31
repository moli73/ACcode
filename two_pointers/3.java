public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int i = 0, j = 0, res = 0, n = s.length();
        char[] str = s.toCharArray();
        for(i = 0; i < n; i++) {
            while(j < n && count[str[j]] == 0) {
                count[str[j]]++;
                j++;
            }
            res = Math.max(res, j - i);
            count[str[i]]--;
        }
        return res;
    }
}
