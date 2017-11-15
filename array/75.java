/*
input:
0,1,2


0,2,1

  |
1,0,2
|   |

    |
0,1,2
|   |

2,1,0

2,0,1



      |         |
1,1,1,0,0,0,2,0,1,2,2
            |
*/
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // while(left < right && nums[left] == 0) {
        //     left++;
        // }
        // while(left < right && nums[right] == 2) {
        //     right--;
        // }
        int i = left;
        while(i <= right) {          相等也要执行
            if(nums[i] == 0) {    //向前换，换回来的肯定是1
                swap(nums, i++, left++);
            } else if(nums[i] == 2) {   {//向后换，换来的有可能是0
                swap(nums, i, right--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
