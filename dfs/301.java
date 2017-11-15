public class Solution {
    private int maxPath = 0;

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        helper(res, new StringBuffer(s), 0);
        return res;
    }

    public void helper(List<String> res, StringBuffer comb, int pos) {
        if(comb.length() < maxPath) {
            return;
        }

        if(isValid(comb)) {
            if(comb.length() == maxPath) {
                res.add(comb.toString());
            } else if(comb.length() > maxPath){
                res.clear();
                res.add(comb.toString());
                maxPath = comb.length();
            }
            return;
        }

        for(int i = pos; i < comb.length(); i++) {
            if(comb.charAt(i) != '(' && comb.charAt(i) != ')') continue;
            if(i != pos && comb.charAt(i) == comb.charAt(i - 1)) continue;//1.避免重复
            char temp = comb.charAt(i);
            helper(res, comb.deleteCharAt(i), i);//2.非常关键的是pos的值还是i
            comb.insert(i, temp);
        }
    }

    public boolean isValid(StringBuffer sb) {
        int count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '(') count++;
            if(sb.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}
