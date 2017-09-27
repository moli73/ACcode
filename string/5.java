class Solution {
    private int start, maxLen;
    public String longestPalindrome(String s) {
        if(s.length() < 2) {
            return s;
        }
        start = 0;
        maxLen = 1;
        for(int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void expand(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if(maxLen < j - i + 1) {
                start = i;
                maxLen = j - i + 1;
            }
            i--;
            j++;
        }
    }
}
