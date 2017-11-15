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

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, target, res, new StringBuilder(), 0, 0, 1);
        return res;
    }

    private void helper(String num, int target, List<String> res, StringBuilder sb, int pos, long sum, long mul) {
        if(pos == num.length()) {
            if(sum == target) {
                res.add(sb.toString());
            }
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            String sub = num.substring(pos, i + 1);
            long cur = Long.parseLong(sub);
            if(pos == 0) {
                sb.append(sub);
                helper(num, target, res, sb, i + 1, sum + cur, cur);
                sb.delete(sb.length() - sub.length(), sb.length());
            } else {
                sb.append("+");
                sb.append(sub);
                helper(num, target, res, sb, i + 1, sum + cur, cur);

                sb.setCharAt(sb.length() - sub.length() - 1, '-');
                helper(num, target, res, sb, i + 1, sum - cur, -cur);

                sb.setCharAt(sb.length() - sub.length() - 1, '*');
                helper(num, target, res, sb, i + 1, sum - mul + mul * cur, mul * cur);

                sb.delete(sb.length() - sub.length() - 1, sb.length());
            }

            if(num.charAt(pos) == '0') {
                break;
            }
        }

    }
}
