public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb,
                                    int[] nums, int remain, int pos){
        if(remain == 0){
            res.add(new ArrayList<Integer>(comb));
        } else if(remain < 0){
            return;
        }

        for(int i = pos; i < nums.length; ++i){
            if(i != pos && nums[i] == nums[i - 1]) continue;
            comb.add(nums[i]);
            helper(res, comb, nums, remain - nums[i], i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
