//two stacks
class Solution {
    public String decodeString(String s) {
        /*
            1.number and [] always come together
            2.once meet number, add it to count integer. (next char must be '[')
            3.once meet [, store the current comb into stack, clear comb
            4.once meet ], pop number from stack, repeat current comb, then pop last comb from stack and combine them

            initial:
                push "" into stack: for case 2[a]
            end:
                1.end by ] --> initial stack with ""
                2.end by letter --> pop and combine all string in stack
            return:
                return res
        */
        Stack<String> stackStr = new Stack<String>();
        Stack<Integer> stackInt = new Stack<Integer>();

        stackStr.push("");
        int count = 0;
        String comb = new String();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {

                count = 10 * count + c - '0';

            } else if(c == '[') {

                stackStr.push(comb);
                comb = new String();

                stackInt.push(count);
                count = 0;

            } else if(c == ']') {

                int rt = stackInt.pop();//when meet ], there always be number in stackInt
                StringBuilder sb = new StringBuilder();

                for(int k = 0; k < rt; k++) {
                    sb.append(comb);
                }

                comb = stackStr.pop() + sb.toString();//stackStr always be string since "" initialization

            } else {
                comb += c;
            }
        }

        return comb;
    }
}


//one stack
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

//recursion
class Solution {
    public String decodeString(String s) {
        /**
            every time meet number, go find match [ ], and do recursion
        */
        if(s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int num = 0;

        while(i < s.length()) {

            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {

                num = num * 10 + c - '0';

            } else if(c == '[') {

                int count = 0;
                int start = i;

                while(i < s.length()) {

                    if(s.charAt(i) == '[') count++;
                    if(s.charAt(i) == ']') count--;

                    if(count == 0) break;
                    i++;
                }//when end the loop, i points one ]

                String pat = decodeString(s.substring(start + 1, i));

                for(int k = 0; k < num; k++) {

                    sb.append(pat);

                }

                num = 0;

            } else {

                sb.append(c);

            }

            i++;
        }

        return sb.toString();
    }
}
