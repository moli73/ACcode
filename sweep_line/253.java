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
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[][] events = new int[2 * n][2];
        for(int i = 0; i < n; i++) {
            events[2 * i][0] = intervals[i].start;
            events[2 * i][1] = 1;
            events[2 * i + 1][0] = intervals[i].end;
            events[2 * i + 1][1] = 0;
        }
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    if(b[1] == 0)
                        return 1;
                    else
                        return -1;
                } else {
                    return a[0] - b[0];
                }
            }
        });
        int res = 0, count = 0;
        for(int[] event : events) {
            if(event[1] == 1) {
                count++;
                res = Math.max(res, count);
            } else {
                count--;
            }
        }
        return res;
    }
}
