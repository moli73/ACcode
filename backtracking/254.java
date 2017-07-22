public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, 2, n);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int start, int n){
        if(comb.size() != 0){
            comb.add(n);
            res.add(new ArrayList<Integer>(comb));
            comb.remove(comb.size() - 1);
        }
        for(int i = start; i <= Math.sqrt(n); ++i){
            if(n % i != 0) {continue;}
            comb.add(i);
            helper(res, comb, i, n / i);
            comb.remove(comb.size() - 1);
        }
    }
}

//mock version:
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        helper(res, comb, n, 2);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int remain, int pos) {
        if(comb.size() > 0) {
            comb.add(remain);//最后一个数单独add
            res.add(new ArrayList<Integer>(comb));
            comb.remove(comb.size() - 1);
        }

        for(int i = pos; i <= Math.sqrt(remain); i++) {//取平方根为界限的话，就不可能将remain除到“终点”，所以不能remain来当return条件
            if(remain % i == 0) {
                comb.add(i);
                helper(res, comb, remain / i, i);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
