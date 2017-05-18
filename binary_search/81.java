public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > nums[end]){
                if(nums[mid] > target && target >= nums[start]) end = mid;
                else start = mid;
            }
            else if(nums[mid] < nums[end]){
                if(nums[mid] < target && target <= nums[end]) start = mid;
                else end = mid;
            }
            else end--;
        }
        return (target == nums[start] || target == nums[end]);
    }
}
