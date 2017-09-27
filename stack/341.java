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
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> s1 = new Stack<>();
    private Stack<NestedInteger> s2 = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger e : nestedList) {
            s1.push(e);
        }
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
    }

    @Override
    public Integer next() {
        return s2.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!s2.empty() && !s2.peek().isInteger()) {
            for(NestedInteger val : s2.pop().getList()) {
                s1.push(val);
            }
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return !s2.empty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
