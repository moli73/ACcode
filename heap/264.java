//version 1 : use heap + HashSet
public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        int[] fac = {2, 3, 5};
        Set<Long> set = new HashSet<>();

        pq.offer((long)1);
        set.add((long)1);

        long res = 1;
        while(n > 0) {
            res = pq.poll();
            n--;
            for(int t = 0; t < 3; t++) {
                if(!set.contains(res * fac[t])) {
                    set.add(res * fac[t]);
                    pq.offer(res * fac[t]);
                }
            }
        }

        return (int)res;
    }
}

//version 2: jiuzhang Solution
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++) {
            int lastNum = nums.get(i - 1);
            while(nums.get(p2) * 2 <= lastNum) p2++;
            while(nums.get(p3) * 3 <= lastNum) p3++;
            while(nums.get(p5) * 5 <= lastNum) p5++;
            nums.add(Math.min(nums.get(p2) * 2, Math.min(nums.get(p3) * 3, nums.get(p5) * 5)));//先移动，后计算。
        }
        return nums.get(n - 1);
    }
}

public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        int p2 = 0, p3 = 0, p5 = 0;
        for(int i = 1; i < n; i++) {
            nums.add(Math.min(nums.get(p2) * 2, Math.min(nums.get(p3) * 3, nums.get(p5) * 5)));//先计算，后移动。
            int min = nums.get(i);
            if(min == nums.get(p2) * 2) p2++;
            if(min == nums.get(p3) * 3) p3++;
            if(min == nums.get(p5) * 5) p5++;
        }
        return nums.get(n - 1);
    }
}
