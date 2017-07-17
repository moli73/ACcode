public class Solution {
    private boolean res = false;

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum % 4 != 0 || sum == 0) {
            return false;
        }

        int target = sum / 4;

        Arrays.sort(nums);
        if(nums[nums.length - 1] > target) {
            return false;
        }

        boolean[] used = new boolean[nums.length];
        helper(nums, used, 0, 0, target, target);

        return res;
    }

    public void helper(int[] nums, boolean[] used, int pos, int count, int remainder, int target) {
        if(count == 3) {
            res = true;
            return;
        }

        if(res || remainder < 0) {
            return;
        }

        if(remainder == 0) {
            count++;
            pos = 0;
            remainder = target;
        }

        for(int i = pos; i < nums.length; i++) {
            if(used[i]) {continue;}
            used[i] = true;
            helper(nums, used, i + 1, count, remainder - nums[i], target);
            used[i] = false;
        }
    }
}
