corner case:
input: [[]]
一定要check empty，在使用peek等method之前

注意：本题每次都先hasNext再next

solution1: one stack
每次list从后往前加入，这样出栈能保证是正序；
每次取出栈顶进行expand，知道栈顶为integer或者空
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();

        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while(!stack.empty() && !stack.peek().isInteger()) {
            NestedInteger temp = stack.pop();

            if(temp.isInteger()) {
                stack.push(temp);
            } else {
                List<NestedInteger> list = temp.getList();
                for(int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));//case : [[]]，pop完了之后，可能不加入，是的stack empty
                }
            }
        }
        return !stack.empty();//最后用是否empty作为check依据
    }
}

two stack方式，完成顺序pop
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
