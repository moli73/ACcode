public class Solution {

    private String[][] letters = {{}, {}, {"a", "b","c"}, {"d", "e", "f"},
                                {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"},
                                {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) return res;
        String comb = new String();
        helper(res, comb, digits, 0);
        return res;
    }

    public void helper(List<String> res, String comb, String digits, int pos){
        if(pos == digits.length()){
            res.add(comb);
            return;
        }

        for(int i = 0; i < letters[digits.charAt(pos) - '0'].length; ++i){
            comb += letters[digits.charAt(pos) - '0'][i];
            helper(res, comb, digits, pos + 1);
            comb = comb.substring(0, comb.length() - 1);
        }
    }
}

//better code:
public class Solution {

    private static final String[] letters = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        String comb = new String();
        helper(res, comb, digits, 0);
        return res;
    }

    public void helper(List<String> res, String comb, String digits, int pos){
        if(pos == digits.length()){
            res.add(comb);
            return;
        }

        int number = digits.charAt(pos) - '0';
        for(int i = 0; i < letters[number].length(); ++i){
            helper(res, comb + letters[number].charAt(i), digits, pos + 1);
        }
    }
}
