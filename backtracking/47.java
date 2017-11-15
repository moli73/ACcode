class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, boolean[] used) {
        if(comb.size() == nums.length) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            if(used[i] == false) {
                used[i] = true;
                comb.add(nums[i]);
                helper(res, comb, nums, used);
                comb.remove(comb.size() - 1);
                used[i] = false;
            }
        }
    }
}
