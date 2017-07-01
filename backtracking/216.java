public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 1 || n > 45 || k < 1 || k > 9){ return res;}

       	List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, 1, n, k);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int pos, int remain, int k){
        if(comb.size() == k){
            if(remain == 0){
                res.add(new ArrayList<Integer>(comb));
            }
            return;
        } else if(remain < 0){
            return;
        }

        for(int i = pos; i <= 9; ++i){
            comb.add(i);
            helper(res, comb, i + 1, remain - i, k);
            comb.remove(comb.size() - 1);
        }
    }
}
