solution 2:
感觉有点像heapfy，三个都计算出一个代表数字，选择最小的一个进行变化。
time: O(n)
space: O(n)
class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while(res.size() < n) {
            int num = Math.min(res.get(p2) * 2, Math.min(res.get(p3) * 3, res.get(p5) * 5));
            res.add(num);
            if(res.get(p2) * 2 == num) {
                p2++;
            }
            if(res.get(p3) * 3 == num) {
                p3++;
            }
            if(res.get(p5) * 5 == num) {
                p5++;
            }
        }
        return res.get(n - 1);
    }
}

solution 1: priority queue + hashset
time: O(nlogn) worst case
space: O(n)
1.用set判断完是否contains后，一点要记得remove或者add
2.数字的越界,问题 Integer.MAX_VALUE / cur >= 2 注意要取等于
或者用long解决
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
不用Long
class Solution {
    public int nthUglyNumber(int n) {
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (int)a - b;
            }
        });

        pq.offer(1);
        int cur = 0;

        while(n > 0) {
            cur = pq.poll();
            n--;

            if(Integer.MAX_VALUE / cur >= 2 && !set.contains(2 * cur)) {
                set.add(2 * cur);
                pq.offer(2 * cur);
            }

            if(Integer.MAX_VALUE / cur >= 3 && !set.contains(3 * cur)) {
                set.add(3 * cur);
                pq.offer(3 * cur);
            }

            if(Integer.MAX_VALUE / cur >= 5 && !set.contains(5 * cur)) {
                set.add(5 * cur);
                pq.offer(5 * cur);
            }
        }

        return cur;
    }
}
