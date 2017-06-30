public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        if(n < 1 || n < k) return res;
        helper(res, comb, 1, n, k);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int pos, int n, int k){
        if(comb.size() == k){
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i = pos; i <= n; ++i){
            comb.add(i);
            helper(res, comb, i + 1, n, k);
            comb.remove(comb.size() - 1);
        }
    }
}
