class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int nn = nums.length;
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nn / 2; i++) {
            sum += nums[2*i];
        }
        return sum;
    }
}

/*
1,4,3,2

n == 2
1,2,3,4
1:1,2
2:3,4
step1: sort
step2: greedy,total 2n numbers, then every 2 numbers form a pair
step3: add all odd pos numbers together is the answer

*/
