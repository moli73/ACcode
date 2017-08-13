public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i = -1; i < nums.length; i++) {
            long left = (i == -1) ? (long)lower - 1 : nums[i];
            long right = (i + 1 == nums.length) ? (long)upper + 1: nums[i + 1];
            String temp = null;
            if(right == 2 + left) {
                temp = String.valueOf(right - 1);
            } else if(right > 2 + left) {
                temp = String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
            }
            if(temp != null) {
                res.add(temp);
            }
        }
        return res;
    }
}
