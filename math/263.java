public class Solution {
    public boolean isUgly(int num) {
        if(num == 0) return false;
        if(num == 1) return true;
        if(num % 2 == 0) return isUgly(num / 2);
        if(num % 3 == 0) return isUgly(num / 3);
        if(num % 5 == 0) return isUgly(num / 5);
        return false;
    }
}

public class Solution {
    public boolean isUgly(int num) {
        for(int i = 2; i < 6 && num > 0; i++) {
            while(num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
