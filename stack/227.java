//best two path Solutionclass Solution {
    public int calculate(String s) {
        List<Integer> res = new ArrayList<>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if(sign == '+') {
                    res.add(num);
                }
                if(sign == '-') {
                    res.add(-num);
                }
                if(sign == '*') {
                    res.set(res.size() - 1, res.get(res.size() - 1) * num);
                }
                if(sign == '/') {
                    res.set(res.size() - 1, res.get(res.size() - 1) / num);
                }
                sign = c;
                num = 0;
            }
        }

        int sum = 0;
        for(int number : res) {
            sum += number;
        }
        return sum;
    }
}

//first time
class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opt = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                continue;
            } else if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                StringBuilder sb = new StringBuilder();
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    sb.append(s.charAt(i++));
                }
                i--;

                int tempNum = Integer.parseInt(sb.toString());
                if(!opt.empty() && opt.peek() == '*') {
                    opt.pop();
                    nums.push(nums.pop() * tempNum);
                } else if(!opt.empty() && opt.peek() == '/') {
                    opt.pop();
                    nums.push(nums.pop() / tempNum);
                } else {
                    nums.push(tempNum);
                }
            } else {
                opt.push(s.charAt(i));
            }
        }

        int res = 0;
        while(!opt.empty()) {
            char operation = opt.pop();
            if(operation == '+') {
                res += nums.pop();
            } else if(operation == '-') {
                res -= nums.pop();
            }
        }
        res += nums.pop();
        return res;
    }
}
