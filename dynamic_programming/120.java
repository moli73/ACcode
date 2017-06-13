public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        if(triangle.size() == 0) return 0;
        int res = 0;
        for(int i = 0; i < triangle.size(); ++i){
            res = Integer.MAX_VALUE;
            for(int j = triangle.get(i).size() - 1; j >= 0; --j){
                if(j == 0){
                    dp[0] = dp[0] + triangle.get(i).get(j);
                } else if(j == triangle.get(i).size() - 1){
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
                res = Math.min(res, dp[j]);
            }
        }
        return res;
    }
}

//better dp status
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; --i){
            for(int j = 0; j <= i; ++j){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
