//loop style
public class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0 || costs[0].length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int minCost1 = 0, minCost2 = 0, min = -1;
        for(int i = 0; i < n; ++i){
            int temp1 = Integer.MAX_VALUE, temp2 = Integer.MAX_VALUE, tempMin = -1;
            for(int j = 0; j < k; ++j){
                int cost = (j != min ? minCost1 : minCost2) + costs[i][j];
                if(cost < temp1){
                    temp2 = temp1;
                    temp1 = cost;
                    tempMin = j;
                } else if(cost < temp2) temp2 = cost;
            }
            minCost1 = temp1; minCost2 = temp2; min = tempMin;
        }
        return minCost1;
    }
}
//dp code style
public class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length; if(n == 0) return 0;
        int k = costs[0].length; if(k == 0) return 0;
        int min1 = -1, minCost1 = Integer.MAX_VALUE, minCost2 = Integer.MAX_VALUE;
        for(int i = 0; i < k; ++i){
            if(costs[0][i] < minCost1){
                minCost2 = minCost1;
                minCost1 = costs[0][i];
                min1 = i;
            } else if(costs[0][i] < minCost2){//the minCost2 and minCost1 could be same but different color
                minCost2 = costs[0][i];
            }
        }
        for(int i = 1; i < n; ++i){
            int temp1 = minCost1, temp2 = minCost2, tempMin = min1;
            minCost1 = Integer.MAX_VALUE; minCost2 = Integer.MAX_VALUE;
            for(int j = 0; j < k; ++j){
                if(j != tempMin){
                    if(temp1 + costs[i][j] < minCost1){
                        minCost2 = minCost1;
                        minCost1 = temp1 + costs[i][j];
                        min1 = j;
                    } else if(temp1 + costs[i][j] < minCost2){
                        minCost2 = temp1 + costs[i][j];
                    }
                } else{
                    if(temp2 + costs[i][j] < minCost1){
                        minCost2 = minCost1;
                        minCost1 = temp2 + costs[i][j];
                        min1 = j;
                    } else if(temp2 + costs[i][j] < minCost2){
                        minCost2 = temp2 + costs[i][j];
                    }
                }
            }
        }
        return minCost1;
    }
}
