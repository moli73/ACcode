import java.util.*;
class Main {
	public static void main(String[] args) {
		Main obj = new Main();
		System.out.println(obj.calculate(args[0]));
	}
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
            if(opt.pop() == '+') {
                res += nums.pop();
            } else if(opt.pop() == '-') {
                res -= nums.pop();
            }
        }
        res += nums.pop();
        return res;
    }
}
