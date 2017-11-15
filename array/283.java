//swap Solution
//time: O(n)
//space: O(1)
//operation swap is number of non-zero numbers
//worst case is all numbers is non-zero when the operation is also n
class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, i, start++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


//assign solution:
//time: O(n)
//space: O(1)
//number of operation is n
class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        while(start < nums.length) {
            nums[start++] = 0;
        }
    }
}
