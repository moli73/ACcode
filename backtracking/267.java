class Solution {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        //count the frequency of the character
        for(char c : s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
            if(map.get(c) % 2 == 1) {
                count++;
            } else {
                count--;
            }
        }

        List<String> res = new ArrayList<>();
        //check if it is palindrome
        if(count > 1) {
            return res;
        }

        List<Character> list = new ArrayList<>();
        String mid = new String();
        //it is like sort
        for(char key : map.keySet()) {
            if(map.get(key) % 2 == 1) {
                mid += key;
            }
            for(int i = 0; i < map.get(key)/ 2; i++) {
                list.add(key);
            }
        }
        boolean[] used = new boolean[list.size()];
        helper(res, list, mid, new StringBuilder(), used);

        return res;
    }

    private void helper(List<String> res, List<Character> list, String mid, StringBuilder left, boolean[] used) {
        if(left.length() == list.size()) {
            StringBuilder sb = new StringBuilder(left);
            sb.append(mid).append(left.reverse());
            res.add(sb.toString());
            left.reverse();//key point to recover the left
            return;
        }
        for(int i = 0; i < list.size(); i++) {
            //important point to skip duplicate
            if(i != 0 && list.get(i) == list.get(i - 1) && used[i - 1] == false) continue;
            if(used[i] == false) {
                used[i] = true;
                left.append(list.get(i));
                helper(res, list, mid, left, used);
                left.deleteCharAt(left.length() - 1);
                used[i] = false;
            }
        }
    }
}
//first time
public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }

        char[] str = s.toCharArray();
        int[] count = new int[256];
        int mark = -1;

        for(int i = 0; i < str.length; i++){
            count[str[i]]++;
        }

        String mid = new String();
        for(int i = 0; i < count.length; i++){
            if(count[i] % 2 == 0) {
                count[i] /= 2;
            } else {
                if(mark == -1){
                    mark = i;
                    count[i] = (count[i] - 1) / 2;
                } else {
                    return res;
                }
            }
        }

        helper(res, new String(), new String(), mid, count, s.length(), mark);

        return res;
    }

    public void helper(List<String> res, String left, String right, String mid,
                            int[] count, int target, int mark){
        if(left.length() + right.length() == target){
            res.add(left + right);
            return;
        }
        else if(left.length() + right.length() + 1 == target){
            res.add(left + (char)mark + right);
            return;
        }

        for(int i = 0; i < count.length; i++){
            if(count[i] == 0) continue;

            count[i]--;
            helper(res, left + (char)i, (char)i + right, mid, count, target, mark);
            count[i]++;
        }
    }
}
