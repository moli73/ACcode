public class MinStack {
    private Stack<Integer> s;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        if(s.empty()) {
            s.push(x);
            min.push(x);
            return;
        }

        if(x < min.peek()) {
            min.push(x);
        } else {
            min.push(min.peek());
        }

        s.push(x);
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
