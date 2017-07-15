public class Solution {
    public String parseTernary(String expression) {
        if(expression == null || expression.length() == 0) {
            return "";
        }

        int n = expression.length();
        if(n == 1) {
            return expression;
        }

        int count = 0, index = 2;
        for(int i = 1; i < n; i++) {
            if(expression.charAt(i) == '?') {
                count++;
            }
            if(expression.charAt(i) == ':') {
                count--;
            }
            if(count == 0) {
                index = i;
                break;
            }
        }
        if(expression.charAt(0) == 'T') {
            return parseTernary(expression.substring(2, index));
        } else {
            return parseTernary(expression.substring(index + 1));
        }

    }
}
