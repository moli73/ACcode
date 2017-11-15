/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 sweep line
 time: O(2nlog2n)
 space: O(2n)
 如果相邻是valid，则排序时，时间重叠，保证一个start，一个end的情况，end在前

 如果相邻是invalid，则排序时，时间重叠，保证一个start，一个end的情况，start在前。
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[][] events = new int[2 * n][2];

        for(int i = 0; i < n; i++) {
            events[2 * i][0] = intervals[i].start;
            events[2 * i][1] = 1;

            events[2 * i + 1][0] = intervals[i].end;
            events[2 * i + 1][1] = -1;
        }

        Arrays.sort(events, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        int max = 0;
        int count = 0;

        for(int[] event : events) {
            if(event[1] == 1) {
                count++;
            } else {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
