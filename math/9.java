class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int num = 0;
        while(num < x) {
            num = 10 * num + x % 10;
            x /= 10;
        }
        return (num == x || num / 10 == x);
    }
}
