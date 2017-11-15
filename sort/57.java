/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;

        List<Interval> res = new ArrayList<Interval>();

        int i = 0;
        for(; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if(interval.end < start) {
                res.add(interval);
            } else if(interval.start > end) {
                break;
            } else {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
            }
        }

        res.add(new Interval(start, end));

        for(; i < intervals.size(); i++) {
            res.add(intervals.get(i));
        }

        return res;
    }
}
