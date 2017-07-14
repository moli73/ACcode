public class Solution {
    public String decodeString(String s) {
        StringBuffer res = new StringBuffer();
        if(s.length() == 0) {
            return res.toString();
        }

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int k = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    k = 10 * k + s.charAt(i) - '0';
                    i++;
                }
                int start = i;
                int count = 0;
                while(i < s.length()) {
                    if(s.charAt(i) == '[') count++;
                    if(s.charAt(i) == ']') count--;
                    if(count == 0) break;
                    i++;
                }
                String str = decodeString(s.substring(start + 1, i));
                for(int m = 0; m < k; m++) {
                    res.append(str);
                }
            } else {
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }
}
