class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        if(s == null || s.length() == 0) {
            return res;
        }

        int n = s.length();
        boolean[][] isValid = new boolean[n][n];

        for(int l = 1; l <= n; l++) {
            for(int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;

                if(l == 1) {

                    isValid[i][j] = true;

                } else {

                    isValid[i][j] = (s.charAt(i) == s.charAt(j)) && (l == 2 || isValid[i + 1][j - 1]);

                }
            }
        }

        List<String> comb = new ArrayList<>();
        helper(res, comb, s, 0, isValid);

        return res;
    }

    private void helper(List<List<String>> res, List<String> comb, String s, int pos, boolean[][] isValid) {

        if(pos == s.length()) {

            res.add(new ArrayList<String>(comb));
            return;

        }

        for(int i = pos; i < s.length(); i++) {

            if(!isValid[pos][i]) continue;

            comb.add(s.substring(pos, i + 1));
            helper(res, comb, s, i + 1, isValid);
            comb.remove(comb.size() - 1);

        }
    }
}

/*
s = "urr"
n = 3
isValid:
    0 1 2
0   1 0 0
1     1 1
2       1
l = 1
i j  substring
0 0   u
1 1   r
2 2   r

l = 2
i j  substring
0 1   ur
1 2   rr


l = 3
i j  substring
0 2   urr  isValid[0][2] = isValid[1][1]


            ()urr
            /          |         \
          (u)rr      (ur)r      (urr)
          /      \
        (u,r)r   (u, rr)
        /
    (u,r,r)
(aaaaaaaa)

*/
