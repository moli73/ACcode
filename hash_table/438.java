class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        if(s.length() < p.length()) {
            return res;
        }

        for(int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }

        int i = 0, j = 0;
        for(j = 0; j < s.length(); j++) {
            count[s.charAt(j) - 'a']--;
            while(count[s.charAt(j) - 'a'] < 0 && i <= j) {
                count[s.charAt(i) - 'a']++;
                i++;
            }
            if(j - i + 1 == p.length()) {
                res.add(i);
            }
        }
        return res;
    }
}
