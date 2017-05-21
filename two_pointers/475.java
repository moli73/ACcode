public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for(int house : houses){
            while(i < heaters.length - 1 && 2 * house >= heaters[i] + heaters[i + 1]) i++;
            res = Math.max(res, Math.abs(heaters[i] - house));
        }
        return res;
    }
}
