public class Solution {
    public int mySqrt(int x) {
        long left = 0, right = x, mid;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(mid * mid == x){
                return (int)mid;
            }
            else if(mid * mid < x){
                left = mid;
            }
            else right = mid;
        }
        if(x >= right * right) return (int)right;
        else if(x >= left * left) return (int)left;
        else return (int)left - 1;

    }
}
//no need to use long type
public class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 0, right = x, mid;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(mid == x / mid){
                return (int)mid;
            }
            else if(mid < x / mid){
                left = mid;
            }
            else right = mid;
        }
        if(x / right >= right) return (int)right;
        else if(x / left >= left) return (int)left;
        else return left - 1;

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
