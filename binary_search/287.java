public class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(numOfSmaller(mid, nums) < mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(numOfSmaller(end, nums) < end) {
            return end;
        } else {
            return start;
        }
    }

    public int numOfSmaller(int val, int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(num < val) {
                count++;
            }
        }
        return count;
    }
}
