public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        int sum = 0, max = Integer.MIN_VALUE;
        int[] minPre = new int[2], res = new int[2];
        minPre[1] = -1;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum - minPre[0] > max) {
                max = sum - minPre[0];
                res[0] = minPre[1] + 1;
                res[1] = i;
            }
            if(sum < minPre[0]) {
                minPre[0] = sum;
                minPre[1] = i;
            }
        }
        int all = sum;
        sum = 0;
        int[] maxPre = new int[2];
        maxPre[1] = -1;
        for(int i = 0; i < A.length - 1; i++) {
            sum += A[i];
            if(all - (sum - maxPre[0]) > max) {
                max = all - (sum - maxPre[0]);
                res[0] = i + 1;
                res[1] = maxPre[1];
            }
            if(sum > maxPre[0]) {
                maxPre[0] = sum;
                maxPre[1] = i;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(res[0]);
        ans.add(res[1]);
        return ans;
    }
}
