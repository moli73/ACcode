public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            max = Math.max(max, map.get(num));
        }
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i <= max; i++) {
            buckets.add(new ArrayList<>());
        }
        for(int num : map.keySet()) {
            buckets.get(map.get(num)).add(num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = max; i >= 0; i--) {
            res.addAll(buckets.get(i));
            if(res.size() == k) {
                return res;
            }
        }
        return res;
    }
}
