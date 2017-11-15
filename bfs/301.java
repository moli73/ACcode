class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        q.offer(s);

        while(!q.isEmpty()) {
            int size = q.size();
            if(res.size() != 0) {
                break;
            }
            Set<String> set = new HashSet<>();
            for(int k = 0; k < size; k++) {
                String str = q.poll();
                if(isValid(str)) {
                    res.add(str);
                    continue;
                }
                for(int i = 0; i < str.length(); i++) {
                    StringBuilder sb = new StringBuilder(str);
                    if(str.charAt(i) == '(' || str.charAt(i) == ')') {
                        sb.deleteCharAt(i);
                        if(!set.contains(sb.toString())) {
                            q.offer(sb.toString());
                            set.add(sb.toString());
                        }
                    }
                }
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}
