class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.empty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if(c == ']') {
                if(stack.empty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if(c == '}') {
                if(stack.empty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.empty();//关键点
    }
}
