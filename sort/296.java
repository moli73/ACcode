public class Solution {
    private List<Integer> row = null;
    private List<Integer> col = null;

    public int minTotalDistance(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        row = new ArrayList<Integer>();
        col = new ArrayList<Integer>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        return getD(row) + getD(col);
    }

    private int getD(List<Integer> nums) {
        Collections.sort(nums);
        int i = 0, j = nums.size() - 1, res = 0;
        while(i < j) {
            res += nums.get(j--) - nums.get(i++);
        }
        return res;
    }
}
