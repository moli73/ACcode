//convert the recursion to iterative soluion with only one stack
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1;
        stack.push(sign);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if(c == '+' || c == '-') {//each time meet the operator do operation
                res += sign * num;
                num = 0;
                sign = (c == '+' ? 1 : -1);
            } else if(c == '(') {//like go to a new recursion
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if(c == ')'){//finish the new recursion
                res += sign * num;
                res = res * stack.pop() + stack.pop();
                num = 0;
                sign = 1;
            }
        }
        res += sign * num;//last number
        return res;
    }
}
//best solution, with tricky part
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, num = 0, sign = 1;
        stack.push(sign);
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else if(c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = stack.peek() * (c == '+' ? 1 : -1);
            } else if(c == '(') {
                stack.push(sign);
            } else if(c == ')'){
                stack.pop();
            }
        }
        res += sign * num;
        return res;
    }
}

//two stack first time
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opt = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {//skip whitespace
                continue;
            } else if(c >= '0' && c <= '9') {//get the number
                int tempNum =0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    tempNum = tempNum * 10 + s.charAt(i++) - '0';
                }
                --i;
                nums.push(tempNum);
                if(!opt.empty() && opt.peek() != '('){
                    operate(nums, opt);
                }
            } else if(c == '(' || c == '+' || c == '-') {
                opt.push(c);
            } else {
                while(opt.peek() != '(') {
                    operate(nums, opt);
                }
                opt.pop();
                while(!opt.empty() && opt.peek() != '(') {
                    operate(nums, opt);
                }
            }
        }

        return nums.peek();
    }

    private void operate(Stack<Integer> nums, Stack<Character> opt) {
        int num2 = nums.pop(), num1 = nums.pop();
        char operation = opt.pop();
        if(operation == '+') {
            nums.push(num1 + num2);
        } else {
            nums.push(num1 - num2);
        }
    }
}
