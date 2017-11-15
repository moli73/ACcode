class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            String rs = new StringBuilder(words[i]).reverse().toString();
            map.put(rs, i);
        }

        for(int i = 0; i < words.length; i++) {
            String s = words[i];
            int left = 0;
            int right = s.length() - 1;
            for(int j = 0; j < s.length(); j++) {
                //add string to left
                if(isPalindrome(s, left, j)) {//prefix len from 1 to n
                    String remain = s.substring(j + 1, s.length());//remain len from  n - 1 to 0
                    if(map.containsKey(remain) && map.get(remain) != i) {//不能是自身
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(remain));
                        temp.add(i);
                        res.add(new ArrayList<Integer>(temp));

                        //handle 本身是palindrome的情况,并且空字符在wrods中有
                        if(remain.length() == 0) {
                            temp.set(0, i);
                            temp.set(1, map.get(remain));
                            res.add(new ArrayList<Integer>(temp));
                        }
                    }

                }
                //add string to right
                if(isPalindrome(s, j + 1, right)) {//remain len from  n - 1 to 0
                    String prefix = s.substring(0, j + 1);
                    if(map.containsKey(prefix) && map.get(prefix) != i) {//不能是自身
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(prefix));
                        res.add(new ArrayList<Integer>(temp));
                    }
                }
            }
        }

        return res;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

}
