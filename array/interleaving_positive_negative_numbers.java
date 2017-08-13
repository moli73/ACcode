class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    private void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public void helper(int[] A, int i, int j) {
        while(i <= j) {
                swap(i, j, A);
                i += 2;
                j -= 2;
        }
    }
    public void rerange(int[] A) {
        // write your code here
        int n = A.length;
        int left = 0, right = n - 1;
        while(left <= right) {
            while(left <= right && A[left] < 0) left++;
            while(left <= right && A[right] > 0) right--;
            if(left <= right) {
                swap(left++, right--, A);
            }
        }
        if(n % 2 == 0) {
            helper(A, 1, n - 2);
        } else {
            if(A[n / 2] > 0) {
                helper(A, 0, n - 2);
            } else {
                helper(A, 1, n - 1);
            }
        }

   }
}
