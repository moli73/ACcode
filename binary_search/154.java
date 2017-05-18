public class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] > nums[end]) start = mid;
            else if(nums[mid] < nums[end]) end = mid;
            else end--;
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
//the worst time complexity is O(n)
