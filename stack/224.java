//two stack solution
class Solution {
    public int calculate(String s) {
        /*
            1.meet (, store the current res into stackNum, store the sign into stackSign
            2.meet ), pop the stackSign, time with current res, and combine the current res with stackNum.peek()

            initial:
                sign = 1;
                res = 0; for case (1 + 1)
            return:
                res
        */

        int sign = 1;
        int res = 0;
        int num = 0;

        Stack<Integer> stackNum = new Stack<Integer>();
        Stack<Integer> stackSign = new Stack<Integer>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {

                num = 10 * num + c - '0';

            } else if(c == '+' || c == '-'){

                res += num * sign;

                //reset
                num = 0;
                sign = c == '+' ? 1 : -1;

            } else if(c == '(') {

                stackNum.push(res);
                res = 0;//reset
                //num must be zero at this time

                stackSign.push(sign);
                sign = 1;//reset

            } else if(c == ')') {

                res += num * sign;
                num = 0;//reset
                sign = 1;

                res = stackNum.pop() + stackSign.pop() * res;

            }
        }

        res += num * sign;

        return res;
    }
}

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
