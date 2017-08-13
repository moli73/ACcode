public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0 || wall.get(0).size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(List<Integer> nums : wall) {
            int sum = 0;
            for(int i = 0; i < nums.size() - 1; i++) {//eliminate the last edge
                sum += nums.get(i);
                if(map.containsKey(sum)) {
                    map.put(sum, map.get(sum) - 1);
                } else {
                    map.put(sum, wall.size() - 1);
                }
            }
        }
        int res = wall.size();
        for(Integer key : map.keySet()) {
            res = Math.min(res, map.get(key));
        }
        return res;
    }
}
