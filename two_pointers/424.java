//version 1: for loop i
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0, j = 0;
        int res = 0, max = 0;
        for(i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                max = Math.max(max, ++map[s.charAt(j) - 'A']);

                if(j - i + 1 - max <= k) {
                    j++;
                } else {
                    map[s.charAt(j) - 'A']--;
                    break;
                }
            }

            res = Math.max(res, j - i);

            if(max == map[s.charAt(i) - 'A']) {
                map[s.charAt(i) - 'A']--;
                max--;
                for(int m = 0; m < 26; m++) {
                    max = Math.max(max, map[m]);
                }
            } else {
                map[s.charAt(i) - 'A']--;
            }

        }
        return res;
    }
}
//version 2: for loop j
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0, j = 0;
        int res = 0, max = 0;
        for(j = 0; j < s.length(); j++) {
            map[s.charAt(j) - 'A']++;
            max = Math.max(max, map[s.charAt(j) - 'A']);
            while(j - i + 1 - max > k) {
                if(map[s.charAt(i++) - 'A']-- == max) {
                    max--;
                    for(int m = 0; m < 26; m++) {
                        max = Math.max(max, map[m]);
                    }
                }
            }

            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
