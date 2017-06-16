public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int min = Integer.MAX_VALUE, res = 0;
        for(int i = 0; i < n; ++i){
            if(prices[i] < min){
                min = prices[i];
            } else if(prices[i] - min > res){
                res = prices[i] - min;
            }
        }
        return res;
    }
}
