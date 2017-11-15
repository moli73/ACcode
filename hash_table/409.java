class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 0);
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        int res = 0;
        boolean flag = false;
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 1) {
                flag = true;
                res += entry.getValue() - 1;
            } else {
                res += entry.getValue();
            }
        }
        return flag == true ? res + 1 : res;
    }
}
