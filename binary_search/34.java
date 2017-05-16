public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid;
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] >= target) end = mid;
            else start = mid;
        }
        if(nums[start] == target) res[0] = start;
        else if(nums[end] == target) res[0] = end;
        start = 0; end = nums.length - 1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] <= target) start = mid;
            else end = mid;
        }
        if(nums[end] == target) res[1] = end;
        else if(nums[start] == target) res[1] = start;
        return res;
    }
}
