//最优解：StringBuilder， append， reverse
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ptr_a = a.length() - 1;
        int ptr_b = b.length() - 1;
        int carry = 0;
        while(ptr_a >= 0 || ptr_b >= 0 || carry != 0) {
            int sum = 0;

            sum += carry;

            if(ptr_a >= 0) {
                sum += a.charAt(ptr_a) - '0';
                ptr_a--;
            }

            if(ptr_b >= 0) {
                sum += b.charAt(ptr_b) - '0';
                ptr_b--;
            }

            carry = sum / 2;
            sum = sum % 2;
            sb.append((char)(sum + '0'));
        }
        return sb.reverse().toString();
    }
}

class Solution {
    public String addBinary(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        int i = l1 - 1, j = l2 - 1;
        String res = new String();
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0) {
            int temp = 0;
            temp = carry + (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0);
            carry = temp / 2;
            temp %= 2;
            res = (char)(temp + '0') + res;
        }
        return res;
    }
}
