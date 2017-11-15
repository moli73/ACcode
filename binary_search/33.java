class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while(left + 1 < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > nums[right]) {//right part
                if(nums[left] <= target && target < nums[mid]) {    可能与边界相同
                    right = mid;
                } else {
                    left = mid;
                }
            } else {//left part
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        if(nums[left] == target) {
            return left;
        } else if(nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
