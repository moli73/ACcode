public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) {
            return new double[] {};
        }
        int n = nums.length;
        double[] res = new double[n - k + 1];
        Queue<Integer> left = new PriorityQueue<>(n, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                if(b > a) {
                    return 1;
                } else if(b < a) {
                    return -1;
                } else {
                    return 0;//这种写法，防止越界。
                }
            }
        });
        Queue<Integer> right = new PriorityQueue<>(n);

        for(int i = 0; i < k; i++) {
            addNum(left, right, nums[i]);
        }
        res[0] = getMedian(left, right);

        for(int i = k; i< n; i++) {
            removeNum(left, right, nums[i - k]);
            addNum(left, right, nums[i]);
            res[i - k + 1] = getMedian(left, right);
        }

        return res;
    }

    public double getMedian(Queue<Integer> left, Queue<Integer> right) {
        if(left.size() == right.size()) {
            return ((double)left.peek() + (double)right.peek()) / 2;
        } else {
            return (double)right.peek();
        }
    }

    public void addNum(Queue<Integer> left, Queue<Integer> right, int num) {
        if(left.size() == 0 && right.size() == 0) {
            right.offer(num);
            return;
        }
        double median = getMedian(left, right);
        if(num >= median) {
            right.offer(num);
        } else {
            left.offer(num);
        }

        if(left.size() > right.size()) {
            right.offer(left.poll());
        } else if(left.size() + 1 < right.size()) {
            left.offer(right.poll());
        }
    }
    public void removeNum(Queue<Integer> left, Queue<Integer> right, int num) {
        double median = getMedian(left, right);
        if(num < median) {
            left.remove(num);
        } else {
            right.remove(num);
        }

        if(left.size() > right.size()) {
            right.offer(left.poll());
        } else if(left.size() + 1 < right.size()) {
            left.offer(right.poll());
        }
    }
}
