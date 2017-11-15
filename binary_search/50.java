class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        if (n < 0) {
             return 1 / x * myPow(1 / x, -(n+1));
        }

        double res = 1;
        while(n > 0) {
            if((n & 1) == 1) {
                res *= x;
            }
            x = x * x;
            n = n >> 1;
        }
        return res;

    }
}

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        if (n < 0) {
             return 1 / x * myPow(1 / x, -(n+1));//防止n == Integer.MIN_VALUE取反越界。
        }

        double res = myPow(x, n / 2);//double myPow
        if(n % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }

    }
}

class Solution {
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;

        if (n < 0) {
             return 1 / x * myPow(1 / x, -(n+1));
        }

        //square x
        if(n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2) * x;
        }

    }
}
