//better code
双指针移动找循环。
class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String s = "1";

        for(int k = 1; k < n; k++) {

            StringBuilder sb = new StringBuilder();

            int start = 0;

            while(start < s.length()) {

                int j = start;

                while(j < s.length() && s.charAt(j) == s.charAt(start)) {
                    j++;
                } 退出loop时候，j == s.length或者j与start不相等

                sb.append(String.valueOf(j - start)).append(s.charAt(start));
                start = j;
            }
            s = sb.toString();
        }
        return s;
    }
}

for循环找相同的方式。

class Solution {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }

        String s = "1";

        for(int k = 1; k < n; k++) {

            StringBuilder sb = new StringBuilder();
            int count = 1;
            char c = s.charAt(0);

            for(int i = 1; i < s.length(); i++) {
                if(s.charAt(i) != c) {
                    sb.append(String.valueOf(count)).append(c);
                    c = s.charAt(i);
                    count = 1;
                } else {
                    count++;
                }
            }

            sb.append(String.valueOf(count)).append(c);
            s = sb.toString();
        }

        return s;
    }
}
