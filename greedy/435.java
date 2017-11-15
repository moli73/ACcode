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
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });

        if(intervals.length == 0) {
            return 0;
        }

        int last = intervals[0].start;
        int res = 0;
        for(Interval interval : intervals) {
            if(interval.start >= last) {//start与前一个end相同不算overlap
                last = interval.end;
            } else {
                res++;
            }
        }
        return res;
    }
}

/**
等价于找最多有多少个meeting不重合。
step1:按照end排序
step2:取end最小的，如掉重合的meeting（start < cur_end），记录去掉的个数，就是答案。
1 2 3 4 5 6 7 8 9  10
|     |
  | |
    |       |
*/
