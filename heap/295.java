public class MedianFinder {
    private Integer median = null;
    private Queue<Integer> left;
    private Queue<Integer> right;

    /** initialize your data structure here. */
    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(11, new Comparator<Integer>(){
           public int compare(Integer a, Integer b) {
               return (int)(b - a);
           }
        });
    }

    public void addNum(int num) {
        if(median == null) {
            median = num;
            return;
        }

        if(num >= median) {
            right.offer(num);
        } else {
            left.offer(num);
        }

        if(left.size() > right.size()) {
            right.offer(median);
            median = left.poll();
        } else if(left.size() + 1 < right.size()) {
            left.offer(median);
            median = right.poll();
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) {
            return median;
        } else {
            return (double)(median + right.peek()) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

 
//mock version
public class MedianFinder {
    private Queue<Integer> left;
    private Queue<Integer> right;
    private int median;
    private boolean firstNum = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.left = new PriorityQueue<>((x, y) -> y - x);
        this.right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(firstNum) {
            median = num;
            firstNum = false;
            return;
        }

        if(num >= median) {
            right.add(num);
        } else {
            left.add(num);
        }

        if(left.size() == right.size()) {
            return;
        } else if(left.size() > right.size()) {
            right.offer(median);
            median = left.poll();
        } else if(left.size() + 1 < right.size()) {
            left.offer(median);
            median = right.poll();
        }
    }

    public double findMedian() {
        if(left.size() == right.size()) {
            return median;
        } else {
            return ((double)median + (double)right.peek() ) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
