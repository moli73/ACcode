//version 1: O(n^L), n is the number words, and L is the length of word
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> comb = new ArrayList<String>();

        helper(res, comb, words, words[0].length());

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, String[] words, int n){
        if(comb.size() == n){
            res.add(new ArrayList<String>(comb));
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(!isValid(comb, words[i])) continue;

            comb.add(words[i]);
            helper(res, comb, words, n);
            comb.remove(comb.size() - 1);
        }
    }

    public boolean isValid(List<String> comb, String cur){
        int row = comb.size();

        for(int i = 0; i < cur.length() && i < row; i++){
            if(cur.charAt(i) != comb.get(i).charAt(row)){
                return false;
            }
        }

        return true;
    }
}
