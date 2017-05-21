/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> starts = new TreeMap<Integer, Integer>();
        for(int i = 0; i < intervals.length; ++i) starts.put(intervals[i].start, i);
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; ++i){
            Integer key = starts.ceilingKey(intervals[i].end);
            res[i] = key == null ? -1 : starts.get(key);
        }
        return res;
    }
}
