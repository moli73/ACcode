public class Solution {
    public boolean isReflected(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(a[0], b[0]);
            }
        });

        Map<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>();

        for(int[] point : points){
            if (hash.containsKey(point[1])) {
              hash.get(point[1]).add(points[0]);
          } else {
              List<Integer> list = new ArrayList<Intetger>();
              list.add(points[0]);
              hash.put(points[1], list);
          }
        }

        for (Map.entry e : dict) {
            int yValue = e.getKey();
            List<Integer> xValues = e.getValue();

            int i = 0, j = xValues.size() - 1;
            int cur;
            if(i == j){
                cur = xValues.get(0);
            } else {
                cur = ((float)xValues.get(j) - (float)xValues.get(i)) / 2 + xValues.get(i);
            }
            while(i <= j){
                if(cur != ((float)xValues.get(j) - (float)xValues.get(i)) / 2 + xValues.get(i)){
                    return false;
                } else {
                    i++; j--;
                }
            }
        }
        return true;
    }
}
