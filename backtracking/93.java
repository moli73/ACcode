public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        String comb = new String();
        if(s == null || s.length() == 0 || s.length() < 4 || s.length() > 12){
            return res;
        }

        helper(res, comb, s, 0, 0);

        return res;
    }

    public void helper(List<String> res, String comb, String s, int pos, int level){
        if(level == 4){
            if(pos == s.length()){
                comb = comb.substring(0, comb.length() - 1);
                res.add(comb);
            }
            return;
        }

        for(int i = pos; i < s.length(); ++i){
            String sub = s.substring(pos, i + 1);
            if(Integer.parseInt(sub) > 255) break;

            helper(res, comb + sub + '.', s, i + 1, level + 1);
            if(sub.equals("0")) break;
        }
    }
}
