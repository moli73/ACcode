//最优解双指针，左右开扫描, swap的方式
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;//point first val
        int right = nums.length - 1;//point last non-val
        while(left < right) {
            while(left < right && nums[left] != val) left++;
            while(left < right && nums[right] == val) right--;
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;//left, right没有移动，下次进while的时候，会被移动
        }
        if(nums[left] == val) {
            return left;
        } else {
            return left + 1;
        }

    }
}
//双指针，assign的方式，不需要考虑剩下的元素
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;//point first val
        int right = nums.length - 1;//point last non-val
        while(left < right) {
            while(left < right && nums[left] != val) left++;
            while(left < right && nums[right] == val) right--;

            nums[left] = nums[right--];//assign之后注意right--

        }
        //case : val == 1,[1,1,1,1,1]
        if(nums[left] == val) {
            return left;
        //case: val == 1, [2,2,2,1]
        } else {
            return left + 1;
        }
        /*
        3,2,2,3 val = 3
        2,2,2,3 return right + 1
        | |

        1,1,1 val = 1 left == 0
        |
        0,0,0 val = 1
            |
        */


    }
}

//version 1:保持原顺序的移动，利用swap
public class Solution {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                swap(i++, j, nums);
            }
        }
        return i;
    }
}
//version 2:保持原顺序的移动，利用assign
public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}

//two pointer solution，保持原顺序的assign优化
class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;//指向下一个待确定的位置
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                if(start < i) {//如果就是当前位置，就不用assign了
                    nums[start] = nums[i];
                }
                start++;
            }
        }
        return start;
    }
}

//tricky solution, 移动次数是数组中val的个数
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            if(nums[i] == val) {
                int temp = nums[n - 1];
                nums[n - 1] = nums[i];
                nums[i] = temp;
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
