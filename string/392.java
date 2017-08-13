public class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        if(s.length() == 0) {
            return true;
        }
        for(i = 0; i < t.length(); i++) {
            if(s.charAt(j) == t.charAt(i)) {
                j++;
                if(j == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
