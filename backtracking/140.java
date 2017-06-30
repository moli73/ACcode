//version 1: raw DFS backtracking is TLE
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<String>(wordDict);
        List<String> res = new ArrayList<String>();
        String comb = new String();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String word : wordDict){
            min = Math.min(min, word.length());
            max = Math.max(max, word.length());
        }

        helper(res, comb, words, s, min, max);
        return res;
    }

    public void helper(List<String> res, String comb, Set<String> words, String s, int min, int max){
        if(s.length() == 0){
            res.add(comb.substring(0, comb.length() - 1));
            return;
        }

        for(int i = min - 1; i < s.length() && i < max; ++i){
            String sub = s.substring(0, i + 1);
            if(words.contains(sub)){
                helper(res, comb + sub + ' ', words, s.substring(i + 1), min, max);
            }
        }
    }
}

//version 2: DP + DFS backtracking
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<String>(wordDict);
        int n = s.length();
        boolean[][] isWord = new boolean[n][n];
        for(int i = 0; i < n; ++i){
            for(int j = i; j < n; ++j){
                isWord[i][j] = words.contains(s.substring(i, j + 1));
            }
        }

        boolean[] isPossible = new boolean[n];
        for(int i = n - 1; i >= 0; --i){
            isPossible[i] = isWord[i][n - 1];
            for(int j = n - 2; j >= i; --j){
                if(isWord[i][j] && isPossible[j + 1]){
                    isPossible[i] = true;
                    break;
                }
            }
        }

        List<String> res = new ArrayList<String>();
        String comb = new String();

        helper(res, comb, isWord, isPossible, s, 0);
        return res;
    }

    public void helper(List<String> res, String comb, boolean[][] isWord,
                            boolean[] isPossible, String s, int pos){

        if(pos == s.length()){
            res.add(comb.substring(0, comb.length() - 1)); return;
        }
        if(isPossible[pos] == false){ return;}

        for(int i = pos; i < s.length(); ++i){
            if(isWord[pos][i]){
                helper(res, comb + s.substring(pos, i + 1) + ' ', isWord, isPossible, s, i + 1);
            }
        }
    }
}

//version 3:
