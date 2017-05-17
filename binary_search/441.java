public class Solution {
    public int arrangeCoins(int n) {
        long start = 0, end = n, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if((1 + mid) * mid / 2 <= n) start = mid;
            else end = mid;
        }
        if((1 + end) * end / 2 <= n) return (int)end;
        else return (int)start;
    }
}
