//two times binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0, end = matrix.length - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target) end = mid;
            else start = mid;
        }
        int row;
        if(target >= matrix[end][0]) row = end;
        else row = start;

        start = 0; end = matrix[0].length - 1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target) end = mid;
            else start = mid;
        }
        return (matrix[row][start] == target || matrix[row][end] == target);
    }
}
//once binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(matrix[mid / n][mid % n] == target) return true;
            else if(matrix[mid / n][mid % n] > target) end = mid;
            else start = mid;
        }
        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}
