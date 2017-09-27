class Solution {
    public int reverse(int x) {
        long num = 0;
        while(x != 0) {
            num = 10 * num + x % 10;
            x /= 10;
            if(num < Integer.MIN_VALUE || num > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int)num;
    }
}

//tricky
class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int tail = x % 10;
            res = 10 * res + tail;
            if(tail != res % 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }
}
