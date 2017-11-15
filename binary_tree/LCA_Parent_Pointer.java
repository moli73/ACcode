/**
 * Definition of ParentTreeNode:
 *
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        ParentTreeNode AP = A;
        Set<ParentTreeNode> set = new HashSet<>();
        while(AP != null) {
            set.add(AP);
            AP = AP.parent;
        }

        ParentTreeNode BP = B;
        while(!set.contains(BP)) {
            BP = BP.parent;
        }

        return BP;
    }
}
