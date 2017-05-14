public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while(left + 1 < right){
            mid = left + (right - left) / 2;
            if(target == nums[mid]) return mid;
            else if(target < nums[mid]) right = mid;
            else left = mid;
        }
        if(target <= nums[left]) return left;
        else if(target <= nums[right]) return right;
        else return right + 1;
    }
}
