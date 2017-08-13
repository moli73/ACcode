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
