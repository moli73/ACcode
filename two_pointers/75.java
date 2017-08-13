//mock interview
//九章解法：
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;

        while(i <= right) {
            if(nums[i] == 2) {//current is 2
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            else if(nums[i] == 0) {//current is 0
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
                i++;
            } else {//current is 1
                i++;
            }
        }
    }
}

//better code and easy to understand
public class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        //left, means the next possible position to hold 0
        //right, means the next possible position to hold 2
        for(int i = 0; i <= right; i++) {
            while(i < right && nums[i] == 2) {//current is 2, after swap, we need to consider current position with swaped number
                swap(nums, i, right--);
            }//when i > right, we could terminate
            if(i <= right && nums[i] == 0) {//current is 0, after swap, the swaped number must be 1,so we could keep going
                swap(nums, i, left++);
            }
            //current is 1, we could skip and keeping going
        }
    }
}

//final version:
//third times
//一定要先往后放2,因为再把2往后放的时候，有可能从后面把0换前来了，后放0则可解决这个问题。
//同时，把0往前往前放的时候，前面就已经不可能有2了。
//corner case: [1,2,0]
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for(int i = 0; i <= right; i++) {
            while(i <= right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
            }
            while(left <= i && nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}
