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
//version 2: divide and conquer
public class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length == 0) return false;

        Arrays.sort(nums);

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 4 != 0) return false;
        int edgeLen = sum / 4;

        for (int i = 0; i < 4; i++) {
            int start = nums.length - 1;
            if (!findEdge(nums, edgeLen, start)) return false;
        }
        return true;
    }

    private boolean findEdge(int[] nums, int remain, int start) {
        if (remain == 0) {
            return true;
        } else if(remain < 0) {
            return false;
        }

        for (int i = start; i >= 0; i--) {
            if (nums[i] > 0) {

                nums[i] = -nums[i];

                if (findEdge(nums, remain + nums[i], i - 1)) return true;

                else {
                    nums[i] = -nums[i];
                }
            }
        }
        return false;
    }
}
