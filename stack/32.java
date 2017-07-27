//two pass with stack
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int n = s.length();
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) == '(') stack.push(i);
            else{
                if(!stack.empty() && s.charAt(stack.peek()) == '(') stack.pop();
                else stack.push(i);
            }
        }
        int res = 0, right = n, left = 0;
        if(stack.empty()) return n;
        while(!stack.empty()){
            left = stack.pop();
            res = Math.max(res, right - left - 1);
            right = left;
        }
        return res > right ? res : right;
    }
}

//one pass with stack
public class Solution {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//dummy element
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
