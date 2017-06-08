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
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return new int[0];
        int[] temp = new int[3];
        helper(root, res, temp);
        if(temp[1] == temp[2]){
            res.add(temp[0]);
        }
        else if(temp[1] > temp[2]){
            res = new ArrayList<Integer>();
            res.add(temp[0]);
        }
        int[] out = new int[res.size()];
        for(int i = 0; i < res.size(); ++i) out[i] = res.get(i);
        return out;
    }
    public void helper(TreeNode root, List<Integer> res, int[] temp){
        if(root == null) return;
        helper(root.left, res, temp);

        if(temp[1] == 0){
            temp[0] = root.val;
            temp[1] = 1;
        }
        else if(root.val == temp[0]){
            temp[1]++;
        }
        else{
            if(temp[1] == temp[2]){
                res.add(temp[0]);
            }
            else if(temp[1] > temp[2]){
                //res = new ArrayList<Integer>();//this cannot influence the origin arraylist
                res.clear();
                res.add(temp[0]);
                temp[2] = temp[1];
            }
            temp[0] = root.val;
            temp[1] = 1;
        }
        helper(root.right, res, temp);
    }
}

//the two pass solution could replace the clear() function, without transform arraylist to array
//first count the most occurences of modes
//second collect the modes
public class Solution {

    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorder(root);
        return modes;
    }

    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;

    private int[] modes;

    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleValue(root.val);
        inorder(root.right);
    }
}
