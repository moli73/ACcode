public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int target, int pos){
        if(target == 0){
            res.add(new ArrayList<Integer>(comb));
        } else if(target < 0){
            return;
        }
        for(int i = pos; i < nums.length; ++i){
            comb.add(nums[i]);
            helper(res, comb, nums, target - nums[i], i);
            comb.remove(comb.size() - 1);
        }
    }
}
