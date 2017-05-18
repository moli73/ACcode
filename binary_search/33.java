public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > nums[end]){
                if(target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid;
            }
            if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if(nums[start] == target) return start;
        else if(nums[end] == target) return end;
        else return -1;
    }
}
