class Solution {
    public int removeDuplicates(int[] nums) {
        int i = -1, j = 0;
        for(;j < nums.length; j++) {
            if(i == -1 || nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
