//mock interview
public class Solution {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, i = 0;

        while(i < nums.length && i <= right) {
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

//other solution and the best one:
// public class Solution {
//     public void sortColors(int[] nums) {
//         int left = 0;
//         int right = nums.length - 1;
//         for (int i = 0; i <= right; i++){
//             while (nums[i] == 2 && i < right) swap(nums, i, right--);//先检查2，往前换回来的，可能是0，则在后面，还能检查到
//             while (nums[i] == 0 && i > left) swap(nums, i, left++);//检查0，从前面换过来的肯定是1
//             //[1,2,0]
//         }
//     }
//
//     public void swap(int[] nums, int i, int j){
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//     }
// }
