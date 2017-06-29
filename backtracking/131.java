public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }

        List<String> comb = new ArrayList<String>();
        int n = s.length();
        boolean[][] isValid = new boolean[n + 1][n + 1];

        for(int l = 1; l <= n; ++l){
            for(int i = 1; i <= n - l + 1; ++i){
                int j = i + l - 1;

                if(l == 1){
                    isValid[i][j] = true;
                } else {
                    isValid[i][j] = (s.charAt(i - 1) == s.charAt(j - 1)) &&
                                    (l == 2 || isValid[i + 1][j - 1]);
                }
            }
        }

        helper(res, comb, isValid, s, 0);

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, boolean[][] isValid,
                            String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(comb));
        }

        for(int i = pos; i < s.length(); ++i){
            if(!isValid[pos + 1][i + 1]) continue;

            comb.add(s.substring(pos, i + 1));
            helper(res, comb, isValid, s, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
