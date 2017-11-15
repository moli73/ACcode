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


class Solution {
    public boolean isPerfectSquare(int num) {
        for(int i = 1; num > 0; i += 2) {
            num -= i;
        }
        return num == 0;
    }
}


class Solution {
    public boolean isPerfectSquare(int num) {
        for(long i = 1; i * i <= num; i++) {
            if(i * i == num) return true;
        }
        return false;
    }
}
