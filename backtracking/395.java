public class Solution {
    private int res = 0;

    public int longestSubstring(String s, int k) {
        helper(s.toCharArray(), 0, s.length() - 1, k);
        return res;
    }

    public void helper(char[] s, int start, int end, int k) {
        if(start - end + 1 > k) {
            return;
        }

        int[] count = new int[26];
        Set<Character> set = new HashSet<>();
        for(int i = start; i <= end; i++) {
            count[s[i] - 'a']++;
            if(count[s[i] - 'a'] >= k) {
                set.remove(s[i]);
            } else {
                set.add(s[i]);
            }
        }

        if(set.size() == 0) {
            res = Math.max(res, end - start + 1);
            return;
        }

        for(int i = start; i <= end; i++) {
            if(set.contains(s[i])) {
                helper(s, start, i - 1, k);
                start = i + 1;
            }
        }
        helper(s, start, end, k);
    }
}
