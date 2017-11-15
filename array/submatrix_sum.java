1.将2d转换为1d，利用hash做subarray sum
2.两个dummy，是前0个subarray的初始化方便。
将二维压缩成一维
time: O(mmn)
space: O(mn)
public class Solution {
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length, n = matrix[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j - 1];
                //preSum[i][j]代表第j列，前i行的数字和
                //这样压缩成n个数（n列）
            }
        }
        int[][] res = new int[2][2];
        for(int u = 1; u <= m; u++) {
            for(int d = u; d <= m; d++) {//两重循环遍历各种行的组合
                Map<Integer, Integer> map = new HashMap<>();
                int sum = 0;
                for(int j = 0; j <= n; j++) {//遍历各种列的选择
                    sum += preSum[d][j] - preSum[u - 1][j];
                    if(map.containsKey(sum)) {
                        res[0][0] = u - 1;
                        res[0][1] = map.get(sum);
                        res[1][0] = d - 1;
                        res[1][1] = j - 1;
                        return res;
                    } else {
                        map.put(sum, j);
                    }
                }
            }
        }
        return res;
    }
}
