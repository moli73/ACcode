class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                } else if((stack.peek() == '[' && c == ']') ||
                            stack.peek() == '(' && c == ')' ||
                            stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty(); 关键最后判断stack是否为空
    }
}

//tricky code
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else {
                if(stack.empty() || stack.peek() != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
