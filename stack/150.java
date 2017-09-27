class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if(token.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if(token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if(token.equals("/")) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
