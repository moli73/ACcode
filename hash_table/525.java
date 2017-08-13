public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = 2 * sum - (i + 1);
            if(!map.containsKey(diff)) {
                map.put(diff, i);
            }
            if(diff == 0) {
                res = i + 1;
            } else {
                if(map.containsKey(diff)) {
                    res = Math.max(res, i - map.get(diff));
                }
            }
        }
        return res;
    }
}
