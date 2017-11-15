class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int res = 0;
        map.put(0, 1);
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            if(!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            map.put(sum, map.get(sum) + 1);
        }
        return res;
    }
}
