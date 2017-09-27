class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            while(left < right && !helper(s.charAt(left))) {
                left++;
            }
            while(left < right && !helper(s.charAt(right))) {
                right--;
            }
            if(left < right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public boolean helper(char c) {
        if(c >= '0' && c <= '9') return true;
        if(c >= 'a' && c <= 'z') return true;
        if(c >= 'A' && c <= 'Z') return true;
        return false;
    }
}
