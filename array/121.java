public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;
        for(int price : prices) {
            if(price > min) {
                res = Math.max(res, price - min);
            } else {
                min = price;
            }
        }
        return res;
    }
}
