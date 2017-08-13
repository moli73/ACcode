public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = nums.length;
        if(n == 0) {
            return new int[0];
        }
        int[] res = new int[n - k + 1];
        for(int i = 0; i < n; i++) {
            while(dq.size() != 0 && nums[i] > nums[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k - 1) {
                res[i - k + 1] = nums[dq.getFirst()];
            }
            if(dq.getFirst() == i - k + 1) {
                dq.removeFirst();
            }
        }
        return res;
    }
}
