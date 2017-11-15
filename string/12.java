class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        char[][] digit = {{'M', '#', '#'},
                          {'C', 'D', 'M'},
                          {'X', 'L', 'C'},
                          {'I', 'V', 'X'}};
        int x = 10000;
        for(int i = 0; i < 4; i++) {
            num %= x;
            x /= 10;
            helper(digit[i], sb, num / x);
        }
        return sb.toString();
    }

    private void helper(char[] digit, StringBuilder sb, int unit) {
        if(unit == 9) {
            sb.append(digit[0]).append(digit[2]);
        } else if(unit >= 5) {
            sb.append(digit[1]);
            unit -= 5;
            while(unit > 0) {
                sb.append(digit[0]);
                unit--;
            }
        } else if(unit == 4) {
            sb.append(digit[0]).append(digit[1]);
        } else if(unit > 0) {
            while(unit > 0) {
                sb.append(digit[0]);
                unit--;
            }
        }
    }
}
//
public static String intToRoman(int num) {
    String M[] = {"", "M", "MM", "MMM"};
    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
}

class Solution {
    public String intToRoman(int num) {
        String[] unit1 = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] unit2 = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] unit3 = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] unit4 = {"", "M", "MM", "MMM"};
        StringBuilder sb = new StringBuilder();
        sb.append(unit4[num / 1000 % 10]).append(unit3[num / 100 % 10]).append(unit2[num / 10 % 10]).append(unit1[num %10]);
        return sb.toString();
    }
}
