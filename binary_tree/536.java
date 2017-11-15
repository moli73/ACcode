//recursion version
class Solution {
    public TreeNode str2tree(String s) {
        if(s.length() == 0) {
            return null;
        }
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                break;
            }
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, i)));
        int count = 0;
        int start = i;
        while(i < s.length()) {
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
            if(count == 0) break;
            i++;
        }
        if(start < s.length()) {
            root.left = str2tree(s.substring(start + 1, i));
        }
        if(i + 2 < s.length() - 1) {
            root.right = str2tree(s.substring(i + 2, s.length() - 1));
        }
        return root;
    }
}

//iteration version
class Solution {
    public TreeNode str2tree(String s) {
        if(s.length() == 0) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-') {
                int j = i;//记录number的起点
                while(i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-')) {
                    i++;
                }
                TreeNode node = new TreeNode(Integer.parseInt(s.substring(j, i)));
                stack.push(node);//新建的node都入栈
            } else if(s.charAt(i) == '(') {
                i++;
            } else if(s.charAt(i) == ')') {
                TreeNode child = stack.pop();
                if(!stack.empty()) {//避免最后只剩一个node的情况
                    if(stack.peek().left != null) {//先检查left是否存在
                        stack.peek().right = child;
                    } else {
                        stack.peek().left = child;
                    }
                } else {
                    stack.push(child);
                }
                i++;
            }
        }
        return stack.pop();
    }
}

//first time
public class Solution {
    public TreeNode str2tree(String s) {
        if(s.length() == 0) return null;
        int firstPar = s.indexOf('(');
        if(firstPar == -1){
            TreeNode root = new TreeNode(Integer.parseInt(s));
            return root;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(0, firstPar)));

        int leftParCount = 0;
        int lastPar = s.length() - 1;
        for(int i = firstPar; i < s.length(); ++i){
            if(s.charAt(i) == '(') leftParCount++;
            if(s.charAt(i) == ')') leftParCount--;
            if(leftParCount == 0){
                lastPar = i;
                break;
            }
        }

        root.left = str2tree(s.substring(firstPar + 1, lastPar));
        root.right = lastPar >= s.length() - 1 ? null : str2tree(s.substring(lastPar + 2, s.length() - 1));
        return root;
    }
}
