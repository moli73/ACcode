public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, new String(), word.length(), 0);
        return res;
    }

    public void helper(List<String> res, String word, String comb, int remain, int pos){

        res.add(comb + (remain == 0 ? "" : remain));

        for(int i = pos; i < word.length(); i++){
            helper(res, word, comb + (i == pos ? "" : (i - pos)) + word.charAt(i), word.length() - i - 1, i + 1);
        }
    }
}
