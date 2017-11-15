class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : strs) {
           String count = helper(s);
            if(!map.containsKey(count)) {
                map.put(count, new ArrayList<String>());
            }
            map.get(count).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(new ArrayList<String>(entry.getValue()));
        }
        return res;
    }

    private String helper(String s) {
        int[] count = new int[26];
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : count) {
        		sb.append('#').append(num);//可以直接append int， 中间的0也加入了，所以可以区分
        }
        return sb.toString();
    }
}

//sort version
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(new ArrayList<String>(entry.getValue()));
        }

        return res;
    }
}
