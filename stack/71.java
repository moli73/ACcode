//stack solution without split
class Solution {
    public String simplifyPath(String path) {
        path += '/';

        Deque<String> deque = new LinkedList<>();

        int start = 0;
        for(int i = 1; i < path.length(); i++) {
            if(path.charAt(i) == '/') {
                String sub = path.substring(start + 1, i);
                if(sub.equals("..")) {
                    if(deque.size() > 0) {
                        deque.removeLast();
                    }
                } else if(!sub.equals("") && !sub.equals(".")) {
                    deque.addLast(sub);
                }
                start = i;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(deque.size() > 0) {
            sb.append("/").append(deque.removeFirst());
        }

        if(sb.length() == 0) {
            return "/";
        } else {
            return sb.toString();
        }
    }
}

//
class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Deque<String> deque = new LinkedList<>();

        for(String str : arr) {
            if(str.equals("") || str.equals(".")) {
                continue;
            } else if(str.equals("..")) {
                if(deque.size() != 0) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(deque.size() != 0) {
            sb.append("/").append(deque.removeFirst());
        }

        if(sb.length() == 0) {//if deque is empty
            return "/";
        } else {
            return sb.toString();
        }
    }
}
