class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        boolean flag = false;

        for(char key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                if(flag == true) {
                    return false;
                }
                flag = true;
            }
        }
        return true;
    }
}
