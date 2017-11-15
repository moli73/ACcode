1.reverse全部数会越界 ---> reverse一半边
2.loop condition是num1 < num2：
偶数位数：退出循环是num1 == num2
奇数位数：退出循环时num1 > num2，但是num1 / 10 == num2
corner case:
100000
结尾是0的数字，肯定不是palindrome，除了0本身
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) {
            return true;
        }
        if(x % 10 == 0) {
            return false;
        }
        int num1 = 0;
        int num2 = x;
        while(num1 < num2) {
            num1 = num1 * 10 + num2 % 10;
            num2 /= 10;
        }
        return (num1 == num2) || (num1 / 10 == num2);
    }

}
