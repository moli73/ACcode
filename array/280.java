solution1: one pass swap solution
1.偶数脚标i的数字 <= i + 1
2.奇数脚标i的数字 >= i + 1

1，2同时满足的时候，就能构成wiggle sort
In the worst case we swap at most O(n/2) 完全reverse wiggle
An example input is [2,1,3,1,4,1]
time: O(n)
space: O(1)
class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            if(i % 2 == 0) {
                if(nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            } else {
                if(nums[i] < nums[i + 1]) {
                    swap(nums, i, i + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

solution 2: sort
time: O(nlogn)
space: O(1)
排序后，每次跳一个，swap
public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2){
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }
}



public class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        if(n == 0) return;

        int[] temp = new int[n];
        Arrays.sort(nums);

        for(int i = 0; i < n / 2; ++i){
            temp[2 * i] = nums[i];
            temp[2 * i + 1] = nums[n - i - 1];
        }
        if(n % 2 == 1){temp[n - 1] = nums[n / 2];}

        for(int i = 0; i < n; ++i){
            nums[i] = temp[i];
        }

    }
}
