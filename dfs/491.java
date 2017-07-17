public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int pos) {
        if(comb.size() > 1) {
            res.add(new ArrayList<Integer>(comb));
        }
        Set<Integer> set = new HashSet<>();
        for(int i = pos; i < nums.length; i++) {
            if(comb.size() != 0 && nums[i] < comb.get(comb.size() - 1)) {continue;}
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                comb.add(nums[i]);
                helper(res, comb, nums, i + 1);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
