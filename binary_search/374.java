/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            switch (guess(mid)){
                case  1: start = mid; break;
                case -1: end = mid; break;
                case  0: return mid;
            }
        }
        return (guess(start) == 0) ? start : end;
    }
}
