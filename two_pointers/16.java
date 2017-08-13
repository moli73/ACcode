public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int k = 0; k < nums.length; k++) {
            if(k != 0 && nums[k] == nums[k - 1]) continue;
            int t = target - nums[k];
            int i = k + 1, j = nums.length - 1;
            while(i < j) {
                if(Math.abs(target - res) > Math.abs(t - nums[i] - nums[j])) {
                    res = nums[i] + nums[j] + nums[k];
                }

                if(nums[i] + nums[j] == t) {
                    return target;
                } else if(nums[i] + nums[j] > t){
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
