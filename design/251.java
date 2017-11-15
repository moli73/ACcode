public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> itList;
    private Iterator<Integer> it;
    public Vector2D(List<List<Integer>> vec2d) {
        itList = vec2d.iterator();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        if(it != null && it.hasNext()) {//刚开始的时候it为null，其余情况，如果it.hasNext()
            return true;
        } else {//it为null或者!it.hasNext()
            while(itList.hasNext()) {//只要itList.hasNext()，就要不停迭代。
                it = itList.next().iterator();//case like: [[],[],[2]]
                if(it.hasNext()) {
                    return true;
                }
            }
        }
        return false;
    }
}

//other anwser
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        return j.next();
    }

    @Override
    public boolean hasNext() {
        while((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
