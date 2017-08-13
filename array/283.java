public class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(j = 0; j < nums.length; j++) {
            while(i < j && nums[i] != 0) {
                i++;
            }
            if(i < j && nums[j] != 0) {
                swap(i, j, nums);
            }
        }
    }
}

//better code
public class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void moveZeroes(int[] nums) {

        for(int i = 0, j = 0; j < nums.length; j++) {
            if(nums[j] != 0) {
                swap(i++, j, nums);
            }
        }
    }
}
