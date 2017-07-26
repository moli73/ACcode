public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        for (int i = A.length / 2; i >= 0; i--) {
            helper(A, i);
        }
    }
    public void helper(int[] A, int k) {
        while (1 == 1){
            int min = k;
            if (2 * k + 1 < A.length && A[min] > A[2 * k + 1]) {
                min = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[min] > A[2 * k + 2]) {
                min = 2 * k + 2;
            }
            if (min == k){
                break;
            }
            int temp = A[k];
            A[k] = A[min];
            A[min] = temp;
            k = min;
        }
    }
}
