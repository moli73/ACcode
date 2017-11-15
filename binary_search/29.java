利用bit左移1位，数值翻倍的特性，进行答案二分法。
讨论两个数相除的各种情况：a / b
1.b == 0 && a != 0, if a > 0, a / b == MAX; if a < 0, a / b == MIN
2.b == 0 && a == 0,需要跟面试官讨论，返回值
3.b != 0 && a == 0, a / b == 0
4.b == -1 && a == MIN, a / b会overflow，需要跟面试官讨论，返回值

注意，中间变量越界的问题
int 32bit
long 64bit

java abs都是Math.abs(), 在abs前先要对dividend和divisor进行类型转换（long）

The outer loop reduces n by at least half each iteration. So It has O(log a) iterations.
The inner loop has at most O(loga) iterations.
So the overall complexity is O(( log a)^2)
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;           越界case
        }

        if(divisor == -1 && dividend == Integer.MIN_VALUE) {    越界case
            return Integer.MAX_VALUE;
        }

        if(dividend == 0) {
            return 0;
        }

        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while(a >= b) {//如果a < b则res就因该是0
            int shift = 0;
            while(a - (b << shift) >= 0) {//退出时的shift是不满足a - (b << shift) >= 0条件的
                shift++;
            }
            res += 1 << (shift - 1);
            a -= b << (shift - 1);
        }
        return sign > 0 ? res : -res;
    }
}
