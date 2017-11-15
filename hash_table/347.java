better code
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        //count frequency of each number
        for(int num : nums) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        //put each number into buckets
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if(!bucket.containsKey(count)) {
                bucket.put(count, new ArrayList<Integer>());
            }
            bucket.get(count).add(num);
        }
        //get the top k frequent number
        List<Integer> res = new ArrayList<>();
        for(int i = n; i >= 1; i--) {
            if(bucket.containsKey(i)) {
                res.addAll(bucket.get(i));      在得到最后答案的部分，有并列的case，不足k的case需要和面试官讨论。
            }
            if(res.size() == k) break;
        }

        return res;
    }
}

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
