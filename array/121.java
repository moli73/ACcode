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


class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int price : prices) {
            max = Math.max(price - min, max);
            min = Math.min(min, price);
        }
        return max;
    }
}
