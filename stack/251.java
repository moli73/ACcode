public class Vector2D implements Iterator<Integer> {
    private Stack<List<Integer>> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    public Vector2D(List<List<Integer>> vec2d) {
        for(int i = vec2d.size() - 1; i >= 0; i--) {
            s1.push(vec2d.get(i));
        }
    }

    @Override
    public Integer next() {
        return s2.pop();
    }

    @Override
    public boolean hasNext() {
        while(!s1.empty() && s2.empty()) {
            List<Integer> temp = s1.pop();
            for(int i = temp.size() - 1; i >= 0; i--) {
                s2.push(temp.get(i));
            }
        }
        return !s1.empty() || !s2.empty();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
