//version 1: descending stack
public class Solution {
    public int trap(int[] height) {
        Stack<Integer> s = new Stack<>();
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            while(!s.empty() && height[i] > height[s.peek()]) {
                int cur = s.pop();
                if(!s.empty()) {
                    res += (Math.min(height[s.peek()], height[i]) - height[cur]) * (i - s.peek() - 1);
                }
            }
            s.push(i);
        }
        return res;
    }
}
