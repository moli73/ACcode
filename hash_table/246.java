class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) {
            return true;
        }
        int[] map = new int[256];
        map['0'] = '0';
        map['1'] = '1';
        map['6'] = '9';
        map['8'] = '8';
        map['9'] = '6';
        int left = 0;
        int right = num.length() - 1;
        while(left <= right) {
            char l = num.charAt(left);
            char r = num.charAt(right);
            if(map[l] == r) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
