public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, comb, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int[] nums){
        if(comb.size() == nums.length){
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(comb.contains(nums[i])) continue;

            comb.add(nums[i]);
            helper(res, comb, nums);
            comb.remove(comb.size() - 1);
        }
    }
}
