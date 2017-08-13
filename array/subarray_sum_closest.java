public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        List<int[]> preSum = new ArrayList<>();
        preSum.add(new int[] {0, -1});
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum.add(new int[] {sum, i});
        }
        Collections.sort(preSum, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] res = new int[2];
        int d = Integer.MAX_VALUE;
        for(int i = 0; i < preSum.size() - 1; i++) {
            if(d > preSum.get(i + 1)[0] - preSum.get(i)[0]) {
                res[0] = Math.min(preSum.get(i + 1)[1], preSum.get(i)[1]) + 1;
                res[1] = Math.max(preSum.get(i + 1)[1], preSum.get(i)[1]);
                d = preSum.get(i + 1)[0] - preSum.get(i)[0];
            }
        }
        return res;
    }
}
