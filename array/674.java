通向双指针：
模版写法：
类比
443. String Compression
38.count and say
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int i = 0;
        while(i < nums.length) {
            int j = i + 1;
            while(j < nums.length && nums[j] > nums[j - 1]) {
                j++;
            }
            max = Math.max(max, j - i);
            i = j;
        }
        return max;
    }
}
