//recursion
//时间复杂度：O(3^L)
//空间复杂度：O(3^L*L)
class Solution {
    private char[][] map = {{},{},
                            {'a', 'b', 'c'},
                            {'d', 'e', 'f'},
                            {'g', 'h', 'i'},
                            {'j', 'k', 'l'},
                            {'m', 'n', 'o'},
                            {'p', 'q', 'r', 's'},
                            {'t', 'u', 'v'},
                            {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) {
            return res;
        }
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder comb, String digits, int pos) {
        if(pos == digits.length()) {
            res.add(comb.toString());
            return;
        }
        for(int i = 0; i < map[digits.charAt(pos) - '0'].length; i++) {
            helper(res, comb.append(map[digits.charAt(pos) -'0'][i]), digits, pos + 1);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}


//iterative 1,
//时间复杂度：O(3^L)
//空间复杂度：O(3^L*L)
class Solution {
    private char[][] map = {{},{},
                            {'a', 'b', 'c'},
                            {'d', 'e', 'f'},
                            {'g', 'h', 'i'},
                            {'j', 'k', 'l'},
                            {'m', 'n', 'o'},
                            {'p', 'q', 'r', 's'},
                            {'t', 'u', 'v'},
                            {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) {
            return list;
        }
        list.add(new String());//tricky point
        for(int k = 0; k < digits.length(); k++) {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < list.size(); i++) {
                for(int j = 0; j < map[digits.charAt(k) - '0'].length; j++) {
                    String s = list.get(i);
                    s += map[digits.charAt(k) - '0'][j];
                    temp.add(s);
                }
            }
            list = temp;
        }
        return list;
    }
}
//iterative 2 BFS,
class Solution {
    private char[][] map = {{},{},
                            {'a', 'b', 'c'},
                            {'d', 'e', 'f'},
                            {'g', 'h', 'i'},
                            {'j', 'k', 'l'},
                            {'m', 'n', 'o'},
                            {'p', 'q', 'r', 's'},
                            {'t', 'u', 'v'},
                            {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) {
            return list;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(new String());
        for(int k = 0; k < digits.length(); k++) {
            int size = q.size();
            for(int t = 0; t < size; t++) {
                String cur = q.poll();
                for(int j = 0; j < map[digits.charAt(k) - '0'].length; j++) {
                    String s = new String(cur);
                    s += map[digits.charAt(k) - '0'][j];
                    q.offer(s);
                }
            }
        }

        while(!q.isEmpty()) {
            list.add(q.poll());
        }
        return list;
    }
}
