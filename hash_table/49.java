class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs) {
            helper(str, map);
        }
        for(Map.Entry<String, List<String>> item : map.entrySet()) {
            res.add(new ArrayList<>(item.getValue()));
        }
        return res;
    }

    public void helper(String str, Map<String, List<String>> map) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(count[i] != 0) {
                sb.append(String.valueOf(count[i])).append((char)('a' + i));
            }
        }
        String key = sb.toString();
        if(map.containsKey(key)) {
            map.get(key).add(str);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(str);
            map.put(key, temp);
        }
    }
}

//sort version
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
