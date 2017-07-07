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
