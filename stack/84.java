public class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;

        Stack<Integer> s = new Stack<>();
        s.push(-1);

        for(int i = 0; i < n; i++) {
            while(s.peek() != -1 && heights[s.peek()] > heights[i]) {
                int cur = s.pop();
                res = Math.max(res, (i - s.peek() - 1) * heights[cur]);
            }
            s.push(i);
        }

        while(s.peek() != -1) {
            int cur = s.pop();
            res = Math.max(res, (n - s.peek() - 1) * heights[cur]);
        }

        return res;
    }
}
