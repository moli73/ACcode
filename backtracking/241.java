class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input.indexOf('+') == - 1 && input.indexOf('-') == -1 &&
                input.indexOf('*') == -1 && input.indexOf('/') == -1) {
            res.add(Integer.parseInt(input));
            return res;
        }
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*' || c == '/') {
                for(int num1 : diffWaysToCompute(input.substring(0, i))) {
                    for(int num2 : diffWaysToCompute(input.substring(i + 1))) {
                        switch(c) {
                            case '+': res.add(num1 + num2); break;
                            case '-': res.add(num1 - num2); break;
                            case '*': res.add(num1 * num2); break;
                            case '/': res.add(num1 / num2); break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
