class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] cols = new int[n + 1];//use cols[i] to record Queen position in each rows
        //tricky point, make zero column as invalid column.
        helper(res, cols, 1, n);
        return res;
    }

    private void helper(List<List<String>> res, int[] cols, int row, int n) {
        if(row == n + 1) {
            makeBoard(res, cols, n);
            return;
        }
        for(int j = 1; j <= n; j++) {//go through each possible column
            if(isValid(cols, row, j)) {
                cols[row] = j;
                helper(res, cols, row + 1, n);
                cols[row] = 0;
            }
        }
    }

    private boolean isValid(int[] cols, int row, int col) {
        for(int i = 1; i < row; i++) {
            if(cols[i] == col) {//same column
                return false;
            }
            if(cols[i] - col == i - row) {//up-left to bottom-right diag
                return false;
            }
            if(cols[i] + i == col + row) {//up-right to bottom-left diag
                return false;
            }
        }
        return true;
    }

    private void makeBoard(List<List<String>> res, int[] cols, int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j <= n; j++) {
                if(j == cols[i]) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            ans.add(sb.toString());
        }
        res.add(new ArrayList<String>(ans));
    }
}
