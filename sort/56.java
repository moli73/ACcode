/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

 //mock version:
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if(a.start == b.start) {
                    return a.end - b.end;
                } else {
                    return a.start - b.start;
                }
            }
        });

        List<Interval> res = new ArrayList<>();
        Interval temp = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
        for(int i = 0; i < intervals.size(); i++) {
            temp.start = Math.min(temp.start, intervals.get(i).start);
            temp.end = Math.max(temp.end, intervals.get(i).end);
            if(i == intervals.size() - 1 || intervals.get(i + 1).start > temp.end) {//使用提前check下一个元素情况，来决定这一步的操作。类比LC228代码
                res.add(new Interval(temp.start, temp.end));//tricky: 一定要新建一个重新赋值，因为temp是一个object的reference而已。
                temp = new Interval(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
        }
        return res;
    }
}
