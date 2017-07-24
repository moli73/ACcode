public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bull = 0, cow = 0;
        char[] s1 = secret.toCharArray();
        char[] s2 = guess.toCharArray();

        for(int i = 0; i < s1.length; i++) {
            if(s1[i] == s2[i]) {
                bull++;
            } else {
                count[s1[i] - '0']++;
            }
        }

        for(int i = 0; i < s1.length; i++) {
            if(s1[i] == s2[i]) continue;
            if(count[s2[i] - '0'] != 0) {
                cow++;
                count[s2[i] - '0']--;
            }
        }

        return bull + "A" + cow + "B";
    }
}
//better one pass code:
public class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int bull = 0, cow = 0;
        char[] s1 = secret.toCharArray();
        char[] s2 = guess.toCharArray();

        for(int i = 0; i < s1.length; i++) {
            if(s1[i] == s2[i]) {
                bull++;
            } else {
                if(count[s1[i] - '0'] < 0) {//若为负数，说明前面已经在guess中出现过
                    cow++;
                }
                count[s1[i] - '0']++;

                if(count[s2[i] - '0'] > 0) {//若为正数，说明前面已经在secret中出现过
                    cow++;
                }
                count[s2[i] - '0']--;
            }
        }

        return bull + "A" + cow + "B";
    }
}
