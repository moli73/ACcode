time: O(mnl)
space: O(1)
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] C = new int[m][l];
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < m; i++) {
                if(A[i][k] != 0) {
                    for(int j = 0; j < l; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }
}

class Solution {
    class Node {
        int x,y;
        int val;
        Node(int x, int y, int val) {
            this.x=x;
            this.y=y;
            this.val = val;
        }
    }

    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j]!=0) listA.add(new Node(i,j, A[i][j]));
            }
        }
        for (int i=0;i<B.length;i++) {
            for (int j=0;j<B[0].length;j++) {
                if (B[i][j]!=0) listB.add(new Node(i,j, B[i][j]));
            }
        }

        for (Node nodeA : listA) {
            for (Node nodeB: listB) {
                if (nodeA.y==nodeB.x) {
                    result[nodeA.x][nodeB.y] += nodeA.val * nodeB.val;
                }
            }
        }

        return result;
    }
}

time：
创建vectors：O(mn)
vector dot product： O(n1 + n2)
space: O(2mn)
从A建立dense row vectors
从B建立dense column vectors
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {

        List<List<Integer>> rows = helperRow(A);
        List<List<Integer>> cols = helperCol(B);

        int m = A.length;
        int n = B[0].length;
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(rows.get(i).size() == 0 || cols.get(j).size() == 0) {
                    continue;
                }
                res[i][j] = vectorDotProduct(A, B, i, j, rows.get(i), cols.get(j));
            }
        }
        return res;
    }

    public List<List<Integer>> helperRow(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        List<List<Integer>> rows = new ArrayList<List<Integer>>();
        for(int i = 0; i < m; i++) {
            rows.add(new ArrayList<Integer>());
            for(int j = 0; j < n; j++) {
                if(A[i][j] != 0) {
                    rows.get(i).add(j);
                }
            }
        }

        return rows;
    }

    public List<List<Integer>> helperCol(int[][] B) {
        int m = B.length;
        int n = B[0].length;

        List<List<Integer>> cols = new ArrayList<List<Integer>>();
        for(int j = 0; j < n; j++) {
            cols.add(new ArrayList<Integer>());
            for(int i = 0; i < m; i++) {
                if(B[i][j] != 0) {
                    cols.get(j).add(i);
                }
            }
        }

        return cols;
    }

    public int vectorDotProduct(int[][] A, int[][] B, int row, int col, List<Integer> rows, List<Integer> cols) {
        int i = 0;
        int j = 0;
        int n1 = rows.size();
        int n2 = cols.size();
        int res = 0;
        while(i < n1 && j < n2) {
            if(rows.get(i) == cols.get(j)) {
                int k = rows.get(i);
                res += A[row][k] * B[k][col];
                i++;
                j++;
            } else if(rows.get(i) < cols.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
