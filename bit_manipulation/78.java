class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int total = (int)Math.pow(2, nums.length);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < total; i++) {
            res.add(new ArrayList<>());
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < total; j++) {
                if(((j >> i) & 1) == 1) {
                    res.get(j).add(nums[i]);
                }
            }
        }
        return res;
    }
}
