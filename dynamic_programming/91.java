public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0 || s.charAt(0) == '0') return 0;
        int dp1 = 1, dp2 = 1;//zero char the dp state is 1
        for(int i = 1; i < n; ++i){
            int temp = dp2;
            if(s.charAt(i) == '0'){
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') dp2 = dp1;
                else dp2 = 0;
            } else if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) - '0' <= 6)){
                dp2 = dp2 + dp1;
            } //else{
                //dp2 = dp2;
            // }
            dp1 = temp;
        }
        return dp2;
    }
}
