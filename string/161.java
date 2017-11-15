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

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) {
            return false;
        }
        int m = s.length();
        int n = t.length();

        if(m > n) {//保证s是长度小的一个
            return isOneEditDistance(t, s);
        }

        if(n - m > 1) {
            return false;
        }

        int i = 0;
        for(i = 0; i < m; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                break;
            }
        }

        if(i == m) {
            return n - m == 1;
        }

        int j = i;
        if(m != n) {//
            j++;
        } else {
            i++;
            j++;
        }

        while(i < m) {
            if(s.charAt(i) != t.charAt(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }

        return true;
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


class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)) {
            return false;
        }
        int m = s.length();
        int n = t.length();

        if(m > n) {//保证s是长度小的一个
            return isOneEditDistance(t, s);
        }

        if(n - m > 1) {
            return false;
        }

        int i = 0;
        for(i = 0; i < m; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                return s.substring(i + 1, m).equals(t.substring(i + 1, n)) ||
                    s.substring(i, m).equals(t.substring(i + 1, n)) ||
                    s.substring(i + 1, m).equals(t.substring(i, n));
            }
        }

        return n - m == 1;
    }
}
