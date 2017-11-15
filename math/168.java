class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            if(n % 26 == 0) {
                n = (n - 26) / 26;
                sb.append('Z');
            } else {
                sb.append((char)(n % 26 + 'A' - 1));
                n /= 26;
            }
        }
        return sb.reverse().toString();
    }
}

关键点在于：
若n能被26整除，这个时候低位要先去掉一个26

solution2:
n - 1然后在做mod26
n - 1然后再除26. 同样能达到去掉一个26的效果。
class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append((char)((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
