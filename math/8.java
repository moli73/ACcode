class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0) {
            return 0;
        }
        int i = 0, sign = 1;
        long num = 0;
        if(str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(str.charAt(i) == '+') {
            i++;
        }
        for(; i < str.length(); i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                num = 10 * num + str.charAt(i) - '0';
                if(sign * num > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if(sign * num < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int)num * sign;
    }
}
