class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while(left + 1 < right) {
            long mid = left + (right - left) / 2;
            if(mid * mid == x) {
                return (int)mid;
            }
            if(mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if(right * right <= x) {
            return (int)right;
        } else {
            return (int)left;
        }
    }
    //注意输入是0，1的情况

}
//no need to use long type
class Solution {
    public int mySqrt(int x) {
        if(x == 0) {
            return 0;
        }
        int left = 0;
        int right = x;
        while(left + 1 < right) {
            int mid = (left + (right - left) / 2);
            if(mid >= x / mid) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(right <= x / right) {
            return right;
        } else {
            return left;
        }
    }
}
//Newton Method
public class Solution{
    public int mySqrt(int x){
        long r = x;
        while(r * r > x){
            r = (r + x / r) / 2;
        }
        return (int)r;
    }
}
