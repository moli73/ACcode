class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        if(A.length == 0 || A[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int rowLeft = 0, rowRight = A.length - 1, rowMid;
        int colLeft = 0, colRight = A[0].length - 1, colMid;
        while(rowLeft + 1 < rowRight || colLeft + 1 < colRight) {
            if(rowLeft + 1 < rowRight) {
                rowMid = rowLeft + (rowRight - rowLeft) / 2;
                int colMax = colLeft;
                for(int i = colLeft; i <= colRight; i++) {
                    if(A[rowMid][i] > A[rowMid][colMax]) {
                        colMax = i;
                    }
                }
                if(A[rowMid + 1][colMax] > A[rowMid][colMax]) {
                    rowLeft = rowMid;
                } else {
                    rowRight = rowMid;
                }
            }

            if(colLeft + 1 < colRight) {
                colMid = colLeft + (colRight - colLeft) / 2;
                int rowMax = rowLeft;
                for(int i = rowLeft; i <= rowRight; i++) {
                    if(A[i][colMid] > A[rowMax][colMid]) {
                        rowMax = i;
                    }
                }
                if(A[rowMax][colMid + 1] > A[rowMax][colMid]) {
                    colLeft = colMid;
                } else {
                    colRight = colMid;
                }
            }
        }
        if(A[rowLeft][colLeft] > A[rowLeft][colRight]) {//左上 > 右上
            if(A[rowLeft][colLeft] > A[rowRight][colLeft]) {//而且 左上 > 左下
                res.add(rowLeft);
                res.add(colLeft);
            } else if(A[rowRight][colLeft] > A[rowRight][colRight]) {//或者 左下 > 左上 且 左下 > 右下
                res.add(rowRight);
                res.add(colLeft);
            }
        } else {//右上 > 左上
            if(A[rowLeft][colRight] > A[rowRight][colRight]) {//且 右上 > 右下
                res.add(rowLeft);
                res.add(colRight);
            } else if(A[rowRight][colRight] > A[rowRight][colLeft]) {//或者 右下 > 右上 且 右下 > 左下
                res.add(rowRight);
                res.add(colRight);
            }
        }
        return res;
    }
}

//九章答案
class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> find(int x1, int x2, int y1, int y2,
                              int[][] A, boolean flag) {

        if (flag) {
            int mid = x1 + (x2 - x1) / 2;
            int index = y1;
            for (int i = y1; i <= y2; ++i)
                if (A[mid][i] > A[mid][index])
                    index = i;

            if (A[mid - 1][index] > A[mid][index])
                return find(x1, mid - 1, y1, y2, A, !flag);
            else if (A[mid + 1][index] > A[mid][index])
                return find(mid + 1, x2, y1, y2, A, !flag);
            else
                return new ArrayList<Integer>(Arrays.asList(mid, index));
        } else {
            int mid = y1 + (y2 - y1) / 2;
            int index = x1;
            for (int i = x1; i <= x2; ++i)
                if (A[i][mid] > A[index][mid])
                    index = i;

            if (A[index][mid - 1] > A[index][mid])
                return find(x1, x2, y1, mid - 1, A, !flag);
            else if (A[index][mid + 1] > A[index][mid])
                return find(x1, x2, mid + 1, y2, A, !flag);
            else
                return new ArrayList<Integer>(Arrays.asList(index, mid));
        }
    }
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        int n = A.length;
        int m = A[0].length;
        return find(1, n - 2, 1, m - 2, A, true);
    }
}
