//better code pattern
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        int start = 0;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(!map.containsKey(str[i])) {
                map.put(str[i], 0);
            }
            if(map.get(str[i]) == 0) {
                count++;
            }
            map.put(str[i], map.get(str[i]) + 1);
            while(count > k) {
                map.put(str[start], map.get(str[start]) - 1);
                if(map.get(str[start]) == 0) {
                    count--;
                }
                start++;
            }
            if(res < i - start + 1) {
                res = i - start + 1;
            }
        }
        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int count = 0;
        int len = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map[c] == 0) {
                count++;
            }
            map[c]++;
            while(count > k) {
                map[s.charAt(start)]--;
                if(map[s.charAt(start)] == 0) {
                    count--;
                }
                start++;
            }
            len = Math.max(len, i - start + 1);
        }
        return len;
    }
}

//jiuzhang version
public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int i = 0, j = 0, res = 0, count = 0;
        for(i = 0; i < s.length(); i++) {
            while(j < s.length()) {
                if(map[s.charAt(j)] == 0) {
                    if(count == k) {
                        break;
                    }
                    count++;
                }
                map[s.charAt(j++)]++;
            }
            res = Math.max(res, j - i);
            if(--map[s.charAt(i)] == 0) {
                count--;
            }
        }
        return res;
    }
}
