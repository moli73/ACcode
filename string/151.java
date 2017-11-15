public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String str : arr) {
            StringBuilder sb = new StringBuilder(str);
            res.append(sb.reverse()).append(" ");
        }
        return res.reverse().toString().trim();
    }
}
