public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return new ArrayList<Integer>();
        }

        int[] dp = new int[n];
        int[] pre = new int[n];//for printing the best solution
        int maxIndex = 0;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
            pre[i] = i;
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
            }
            if(dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        //print the best solution
        // List<Integer> res = new ArrayList<Integer>();
        // int index = maxIndex;
        // res.add(nums[index]);
        // for(int i = 1; i < dp[maxIndex]; i++) {
        //     index = pre[index];
        //     res.add(nums[index]);
        // }


        List<Integer> res = new ArrayList<>();
        int cur = maxIndex;
        while(cur != path[cur]) {
            res.add(nums[cur]);
            cur = path[cur];
        }
        res.add(nums[cur]);

        return res;
    }
}
