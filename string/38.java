//better code
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            res = helper(res);
        }
        return res;
    }
    public String helper(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            int count = 1;//tricky
            while(j < str.length() - 1 && str.charAt(j) == str.charAt(j + 1)) {//tricky
                count++;
                j++;
            }
            sb.append(String.valueOf(count)).append(str.charAt(j));
            i = j + 1;//tricky
        }
        return sb.toString();
    }
}
//first time
class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            res = helper(res);
        }
        return res;
    }
    public String helper(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 1, count = 1;
        for(; j <= str.length(); j++) {
            if(j == str.length() || str.charAt(i) != str.charAt(j)) {
                sb.append(String.valueOf(count)).append(str.charAt(i));
                i = j;
                count = 1;
            } else if(str.charAt(i) == str.charAt(j)) {
                count++;
            }
        }
        return sb.toString();
    }
}
