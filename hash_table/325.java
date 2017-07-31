public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if(sum == k) {
                res = i + 1;
            }
        }
        return res;
    }
}
