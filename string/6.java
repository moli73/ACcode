public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        int j = 0, d = 1;
        for(int i = 0; i < s.length(); i++) {
            rows[j].append(s.charAt(i));
            if(j == numRows - 1) {
                d = -1;
            } else if(j == 0){
                d = 1;
            }
            j += d;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb : rows) {
            res.append(sb);
        }
        return res.toString();
    }
}
