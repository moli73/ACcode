//version 1: come from 243
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1;
        int res = words.length;
        int currentDistance;
        for (int i = 0; i < words.length; i++) {
            if(word1.equals(word2)) {
                if(words[i].equals(word1)) {
                    i2 = i1;
                    i1 = i;
                }
            } else {
                if (words[i].equals(word1)) {
                    i1 = i;
                } else if (words[i].equals(word2)) {
                    i2 = i;
                }
            }

            if (i1 != -1 && i2 != -1) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }
        return res;

    }
}
