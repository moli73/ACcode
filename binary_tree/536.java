/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
