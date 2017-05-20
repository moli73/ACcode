public class Solution {
        public boolean isPerfectSquare(int num) {
        long start = 0, end = num, mid;//attention: the int range overflow
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(mid * mid == num) return true;
            else if(mid * mid > num) end = mid;
            else start = mid;
        }
        if(start * start == num) return true;
        if(end * end == num) return true;
        return false;
    }
}
