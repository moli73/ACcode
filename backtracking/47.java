public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> comb = new ArrayList<Integer>();
        int[] visited = new int[nums.length];

        Arrays.sort(nums);
        helper(res, comb, nums, visited);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int[] visited){

        if(comb.size() == nums.length){
            res.add(new ArrayList<Integer>(comb));
            return;
        }

        for(int i = 0; i < nums.length; ++i){
            if(i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            if(visited[i] == 1) continue;

            visited[i] = 1;
            comb.add(nums[i]);
            helper(res, comb, nums, visited);
            comb.remove(comb.size() - 1);
            visited[i] = 0;
        }
    }
}
