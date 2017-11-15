public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; ++i){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < n; ++j){
                if(coins[j] <= i){
                    if(dp[i - coins[j]] != Integer.MAX_VALUE)
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;

    }
}
//use amount + 1 as the bound
背包问题：
返回的取的商品数量；
每件商品可以无限取；

所以：矩阵竖着填充。
每次考虑当前硬币取还是不取，状态转移方程两个来源：
能取：则加上dp[n - 1][j - nums[i]]; 都是取最后一行结果
不取：则为dp[i - 1][j]
二者取较小值。
dp初始值为amount + 1即可，不需要INT_MAX
dp[0] = 0;

return 注意check是否有解
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(n == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for(int j = 1; j <= amount; j++) {   //矩阵竖着填充。
            dp[j] = amount + 1;    //dp初始值为amount + 1即可，不需要INT_MAX
            for(int i = 0; i < n; i++) {    //每次考虑当前硬币取还是不取
                if(j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
