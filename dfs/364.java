/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    private int sum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int startLevel = helper(nestedList);
        add(startLevel, nestedList);
        return sum;
    }
    public void add(int weight, List<NestedInteger> nestedList) {
        for(NestedInteger item : nestedList) {
            if(item.isInteger()) {
                sum += item.getInteger() * weight;
            } else {
                add(weight - 1, item.getList());
            }
        }
    }

    public int helper(List<NestedInteger> nestedList) {
        int level = 1;
        for(NestedInteger item : nestedList) {
            if(!item.isInteger()) {
                level = Math.max(level, helper(item.getList()) + 1);
            }
        }
        return level;

    }
}
