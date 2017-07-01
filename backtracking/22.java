public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n < 1) return res;
        String comb = new String();
        helper(res, comb, 0, 0, n);
        return res;
    }

    public void helper(List<String> res, String comb, int left, int right, int n){
        if(left == n && right == n){
            res.add(comb);
            return;
        }

        if(left > right){
            helper(res, comb + ')', left, right + 1, n);
        }
        if(left != n){
            helper(res, comb + '(', left + 1, right, n);
        }
    }
}
