public class Solution {
    public List<String> addOperators(String num, int target) {
      List<String> res = new ArrayList<>();
      helper(res, new String(), num, 0, 0, target, 0);
      return res;
    }

    public void helper(List<String> res, String path, String num, int pos, long comb, int target, long mul) {
        if(pos == num.length()) {
            if(comb == target) {
                res.add(path);
            }
        }

        for(int i = pos; i < num.length(); i++) {
            String sub = num.substring(pos, i + 1);
            long val = Long.parseLong(sub);//tricky

            if(pos == 0) {//tricky
                helper(res, sub, num, i + 1, val, target, val);
            } else {
                helper(res, path + '+' + sub, num, i + 1, comb + val, target, val);
                helper(res, path + '-' + sub, num, i + 1, comb - val, target, -val);
                helper(res, path + '*' + sub, num, i + 1, comb - mul + mul * val, target, mul * val);
            }

            if(num.charAt(pos) == '0') {//tricky
                break;
            }
        }
    }
}
