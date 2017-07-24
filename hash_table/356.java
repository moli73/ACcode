//conern case: [[16, 1], [-16, 1], [16, 1]] --> true
//version 1:
//step 1: sort the points by x value
//step 2: group the points by y value, and eliminate the duplicate points
//step 3: check the mid line from two sides
public class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();

        for(int[] point : points){
            if (hash.containsKey(point[1])) {
                if(hash.get(point[1]).contains(point[0])) continue;//there could be duplicate points
                hash.get(point[1]).add(point[0]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(point[0]);
                hash.put(point[1], list);
            }
        }

        Float line = null;
        for (int yValue : hash.keySet()) {
            List<Integer> xValues = hash.get(yValue);

            int i = 0, j = xValues.size() - 1;
            while(i <= j){
                if(line == null) {
                    line = ((float)xValues.get(j) - (float)xValues.get(i)) / 2 + xValues.get(i);
                } else if(line != ((float)xValues.get(j) - (float)xValues.get(i)) / 2 + xValues.get(i)){
                    return false;
                } else {
                    i++; j--;
                }
            }
        }
        return true;
    }
}

//version 2: 可以拉通了思考，看所有点的横坐标范围。现求出可能mid line横坐标，然后，check是否所有点都有对应反射点。
public class Solution {
    public boolean isReflected(int[][] points) {
        Set<String> set = new HashSet<>();
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int[] point : points){
            left = Math.min(left, point[0]);
            right = Math.max(right, point[0]);
            String str = point[0] + "," + point[1];//1.tricky to record the x, y value
            set.add(str);
        }

        int sum = left + right;

        for(int[] point : points){
            String str = (sum - point[0]) + "," + point[1];//2.tricky to check the reflective point
            if(!set.contains(str)){
                return false;
            }
        }

        return true;
    }
}
