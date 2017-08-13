public class Solution {
    public int splitArray(int[] nums, int m) {
        long start = 0, end = 0;
        for(int num : nums) {
            end += num;
        }

        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(numOfSub(nums, mid) > m) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(numOfSub(nums, start) == m) {
            return (int)start;
        } else {
            return (int)end;
        }
    }

    public int numOfSub(int[] nums, long mid) {
        int count = 0;
        int i = 0;
        while(i < nums.length) {
            if(nums[i] > mid) return 51;
            long cur = 0;
            count++;
            while(i < nums.length && cur + nums[i] <= mid) {
                cur += nums[i];
                i++;
            }
        }
        return count;
    }
}
