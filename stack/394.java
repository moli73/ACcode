public class Solution {
    public String decodeString(String s) {
        if(s.length() == 0) {
            return new String();
        }
        char[] str = s.toCharArray();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < str.length; i++) {
            String cur = new String();
            if(str[i] >= '0' && str[i] <= '9') {
                cur += str[i];
                while(str[i + 1] >= '0' && str[i + 1] <= '9') {
                    i++;
                    cur += str[i];
                }
                stack.push(cur);
            } else if(str[i] == '[') {
                cur += '[';
                stack.push(cur);
            } else if(str[i] == ']') {
                String seed = stack.pop();//pop the string
                stack.pop();//pop the '['
                for(int k = Integer.parseInt(stack.pop()); k > 0; k--) {
                    cur += seed;
                }
                while(!stack.empty() && !stack.peek().equals("[")) {
                    cur = stack.pop() + cur;
                }
                stack.push(cur);
            } else {
                cur += str[i];
                while(!stack.empty() && !stack.peek().equals("[")) {
                    cur = stack.pop() + cur;
                }
                stack.push(cur);
            }
        }
        return stack.peek();
    }
}
