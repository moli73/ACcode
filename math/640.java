class Solution {
    public String solveEquation(String equation) {
        int flag = 1;//flag为1，标志在等式左边
        int cof = 0;//记录x的系数
        int sum = 0;//记录常数的系数
        int sign = 1;//当前正负
        int count = 0;//当前数字大小
        for(int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if(c >= '0' && c <= '9') {
                count = 10 * count + c - '0';
            } else if (c == 'x') {//碰到x，则更新cof大小
                //case like 0x = x
                if(count == 0 && i > 0 && equation.charAt(i - 1) == '0') {
                    cof += 0;
                } else {
                    cof += sign * flag * (count == 0 ? 1 : count); //case like x = x 的情况
                }
                count = 0;//reset
                sign = 1;
            } else if(c == '=') {
                sum += sign * (flag * -1) * count;
                count = 0; //reset
                sign = 1;
                flag = -1; //flip flag
            } else {
                sum += sign * (flag * -1) * count;
                count = 0;//reset
                sign = (c == '+' ? 1 : -1);//set sign
            }
        }
        sum += sign * (flag * -1) * count;//结尾的数字更新，如果是x结尾，则不会更新。
        if(cof == 0) {
            if(sum != 0) {
                return "No solution";
            } else {
                return "Infinite solutions";
            }
        } else {
            return "x=" + String.valueOf(sum / cof);
        }
    }
}
