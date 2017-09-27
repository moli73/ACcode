//time O(n)
//space O(1)
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();


        if(s.equals(t)) {// preprocess
            return false;
        }

        if(m < n) {// tricky part
            return isOneEditDistance(t, s);
        }

        int i = 0;
        int j = 0;
        while(i < m && j < n && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }

        if(m == n) {//tricky part
            j++;
        }
        i++;

        while(i < m && j < n) {
            if(s.charAt(i) != t.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }

        return (m == n) || (m == n + 1);//two case
    }
}

//time O(n)
//space O(n)
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        for(int i = 0; i < Math.max(m, n); i++) {
            if(i == m) return n - m == 1;
            if(i == n) return m - n == 1;
            if(s.charAt(i) != t.charAt(i)) {
                if(m > n) return s.substring(i + 1).equals(t.substring(i));
                if(n > m) return s.substring(i).equals(t.substring(i + 1));
                if(m == n) return s.substring(i + 1).equals(t.substring(i + 1));
            }
        }
        return false;
    }
}
