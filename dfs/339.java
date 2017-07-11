/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 //version 1: traversal solution
public class Solution {
    private int res = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        for(NestedInteger item : nestedList) {
            helper(item, 1);
        }
        return res;
    }

    public void helper(NestedInteger item, int level) {
        if(item.isInteger()) {
            res += level * item.getInteger();
            return;
        }

        for(NestedInteger next : item.getList()) {
            helper(next, level + 1);
        }
    }
}
//version 2: divide and conquer
public int depthSum(List<NestedInteger> nestedList) {
    return depthSum(nestedList, 1);
}

public int depthSum(List<NestedInteger> list, int depth) {
    int sum = 0;
    for (NestedInteger n : list) {
        if (n.isInteger()) {
            sum += n.getInteger() * depth;
        } else {
            sum += depthSum(n.getList(), depth + 1);
        }
    }
    return sum;
}
