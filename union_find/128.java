public class Solution {
    private Map<Integer, Integer> father = null;
    private Map<Integer, Integer> count = null;
    private int res = 1;//初始值为1

    private int find(int x) {
        if(father.get(x) == x) {
            return x;
        }
        father.put(x, find(father.get(x)));
        return father.get(x);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b) {
            father.put(root_a, root_b);
            count.put(root_b, count.get(root_a) + count.get(root_b));//二者影响结果
            res = Math.max(res, count.get(root_b));
        }
    }

    public int longestConsecutive(int[] nums) {
        father = new HashMap<>();
        count = new HashMap<>();
        if(nums.length == 0) {//corner case
            return 0;
        }

        for(int num : nums){
            if(!father.containsKey(num)) {
                father.put(num, num);
                count.put(num, 1);
            }

            if(father.containsKey(num - 1)) {
                union(num, num - 1);
            }

            if(father.containsKey(num + 1)) {
                union(num, num + 1);
            }
        }

        return res;
    }
}


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 0;

        for(int num : nums) {
            set.add(num);
        }

        for(int i = 0; i < nums.length; i++) {
            int count = 1;

            int num = nums[i] - 1;

            //to left
            while(set.contains(num)) {
                count++;
                set.remove(num);
                num--;
            }

            //to right
            num = nums[i] + 1;
            while(set.contains(num)) {
                count++;
                set.remove(num);
                num++;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
