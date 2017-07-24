public class Solution {
    private boolean res = false;

    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> hash = new HashMap<Character, String>();
        Set<String> set = new HashSet<String>();
        helper(hash, set, pattern, str, 0, 0);
        return res;
    }

    public void helper(Map<Character, String> hash, Set<String> set, String pattern, String str, int m, int n){
        if(res == true){
            return;
        }

        if(m == pattern.length() && n == str.length()){
            res = true;
            return;
        }

        if(m == pattern.length() || n == str.length()){
            return;
        }

        char key = pattern.charAt(m);

        if(hash.containsKey(key)) {
            String sub = hash.get(key);
            if(str.startsWith(sub, n)){
                helper(hash, set, pattern, str, m + 1, n + sub.length());
            }
        } else {
            for(int i = n; i < str.length(); i++){
            String sub = str.substring(n, i + 1);
                if(!set.contains(sub)) {
                    set.add(sub);
                    hash.put(key, sub);
                    helper(hash, set, pattern, str, m + 1, i + 1);
                    set.remove(sub);
                    hash.remove(key);
                }
            }
        }
    }

}
