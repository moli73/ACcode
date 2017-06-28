public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(res, comb, nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int pos){
        res.add(new ArrayList<Integer>(comb));
        for(int i = pos; i < nums.length; ++i){
            if(i != pos && nums[i] == nums[i - 1]) continue;
            comb.add(nums[i]);
            helper(res, comb, nums, i + 1);
            comb.remove(comb.size() - 1);
        }
    }
}
