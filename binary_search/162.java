public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) return mid;
            else if(nums[mid - 1] > nums[mid]) end = mid;//不会碰见边界值。
            else start = mid;
        }
        return nums[start] > nums[end] ? start : end;
    }
}
