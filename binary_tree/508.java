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
    HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
    int maxCount = 0;//global variable
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root);

        for(int key : hash.keySet()){
            if(hash.get(key) == maxCount){
                list.add(key);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; ++i) res[i] = list.get(i);

        return res;

    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        if(hash.containsKey(sum)){//the style in jdk 7
            hash.put(sum, hash.get(sum) + 1);
        } else{
            hash.put(sum, 1);
        }
        maxCount = Math.max(maxCount, hash.get(sum));//good solution
        return sum;
    }
}
