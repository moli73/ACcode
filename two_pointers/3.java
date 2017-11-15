//best solution：
//使用char和脚标的pair，只需要移动指针n次
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(map.containsKey(str[i])) {
                start = Math.max(start, map.get(str[i]) + 1);
            }
            map.put(str[i], i);
            if(res < i - start + 1) {
                res = i - start + 1;
            }
        }
        return res;
    }
}

//better code pattern
//这个解法，是用char和count的pair，需要移动指针2n次。
//这种解法，可以用set直接代替map
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0;
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++) {
            if(!map.containsKey(str[i])) {
                map.put(str[i], 0);
            }
            map.put(str[i], map.get(str[i]) + 1);
            while(map.get(str[i]) > 1) {
                map.put(str[start], map.get(str[start]) - 1);
                start++;
            }
            if(res < i - start + 1) {
                res = i - start + 1;
            }
        }
        return res;
    }
}

//jiuzhang version
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int i = 0, j = 0, res = 0, n = s.length();
        char[] str = s.toCharArray();
        for(i = 0; i < n; i++) {
            while(j < n && count[str[j]] == 0) {
                count[str[j]]++;
                j++;
            }
            res = Math.max(res, j - i);
            count[str[i]]--;
        }
        return res;
    }
}
