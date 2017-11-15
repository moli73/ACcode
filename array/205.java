class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char s_c = s.charAt(i);
            char t_c = t.charAt(i);
            if(st[s_c] == 0 && ts[t_c] == 0) {
                st[s_c] = t_c;
                ts[t_c] = s_c;
            } else {
                if(st[s_c] != t_c || ts[t_c] != s_c) {
                    return false;
                }
            }
        }
        return true;
    }
}
//record the last used position of each char in s and t
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] scp = new int[256];
        int[] tcp = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(scp[sc] != tcp[tc]) {
                return false;
            }
            scp[sc] = i + 1;
            tcp[tc] = i + 1;
        }
        return true;
    }
}
