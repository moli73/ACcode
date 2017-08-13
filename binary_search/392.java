public class Solution {
    public boolean isSubsequence(String s, String t) {
        List<List<Integer>> pos = new ArrayList<>();
        for(int i = 0; i < 256; i++) {
            pos.add(new ArrayList<>());
        }
        for(int i = 0; i < t.length(); i++) {
            pos.get(t.charAt(i)).add(i);
        }
        int bound = -1;
        for(char c : s.toCharArray()) {
            if(pos.get(c).size() == 0) {
                return false;
            }
            int left = 0, right = pos.get(c).size() - 1;
            while(left + 1 < right) {
                int mid = left + (right - left) / 2;
                if(pos.get(c).get(mid) > bound) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if(pos.get(c).get(left) > bound) {
                bound = pos.get(c).get(left);
            } else if(pos.get(c).get(right) > bound) {
                bound = pos.get(c).get(right);
            } else {
                return false;
            }
        }
        return true;
    }
}
