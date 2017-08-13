public class Solution {
    public int findKthLargest(int[] nums, int k) {
        qSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }
    public void qSelect(int[] nums, int left, int right, int k) {
        if(left < right) {
            int mid = partition(nums, left, right);
            if(mid != k) {
                qSelect(nums, left, mid - 1, k);
                qSelect(nums, mid + 1, right, k);
            }
        }
    }
    public int partition(int[] nums, int left, int right) {
        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(nums[j] <= nums[right]) {
                i++;
                swap(i, j, nums);
            }
        }
        swap(i + 1, right, nums);
        return i + 1;
    }
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
