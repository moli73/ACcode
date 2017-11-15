class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) {
            return true;
        }
        int left = 0;
        int right = num.length() - 1;
        while(left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            if((l == '0' && r == '0') || (l == '1' && r == '1') || (l == '6' && r == '9') ||
                    (l == '8' && r == '8') || (l == '9' && r == '6')) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
