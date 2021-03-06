public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        int n = buildings.length;
        if(n == 0) {
            return new ArrayList<>();
        }
        int[][] events = new int[2 * n][2];
        for(int i = 0; i < n; i++) {
            events[2 * i][0] = buildings[i][0];
            events[2 * i][1] = buildings[i][2];
            events[2 * i + 1][0] = buildings[i][1];
            events[2 * i + 1][1] = -buildings[i][2];
        }
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) {//pos same
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        Queue<Integer> pq = new PriorityQueue<>(2 * n, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        List<int[]> res = new ArrayList<>();
        int max = 0;
        pq.offer(max);
        for(int[] val : events) {
            if(val[1] >= 0) {
                pq.offer(val[1]);
            } else {
                pq.remove(-val[1]);
            }
            if(pq.peek() != max) {
                max = pq.peek();
                res.add(new int[] {val[0], max});
            }
        }
        return res;
    }
}
