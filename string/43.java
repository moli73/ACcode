class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--) {
            if(num1.charAt(i) == '0') continue; //skip the 0
            for(int j = num2.length() - 1; j >= 0; j--) {
                if(num2.charAt(j) == '0') continue; //skip the 0
                int k = i + j + 1;
                int sum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[k] += sum;
                int carry = res[k] / 10;
                res[k] %= 10;
                k--;
                while(carry > 0) {//carry可能连续进位，需要连续更新
                    res[k] += carry;
                    carry = res[k] / 10;
                    res[k--] %= 10;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < res.length) {
            if(res[i] != 0) {
                break;
            } else {
                i++;
            }
        }
        while(i < res.length) {
            sb.append(String.valueOf(res[i++]));
        }
        return sb.toString();
    }
}
