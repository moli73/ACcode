class Solution {
    private int start = 0;
    private int len = 0;

    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            helper(str, i, i);
            helper(str, i, i + 1);
        }
        return s.substring(start, start + len);
    }

    private void helper(char[] str, int left, int right) {
        if(left < 0 || right >= str.length) {
            return;
        }
        while(left >= 0 && right < str.length && str[left] == str[right]) {
            left--;
            right++;
        }
        if(right - left - 1 > len) {
            start = left + 1;
            len = right - left - 1;
        }
    }
}
