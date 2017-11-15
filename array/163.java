//better code
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        //这样的初始值，处理可能有的首段range
        long start = (long)lower;//表示miss range的起点
        long end = (long)lower;//表示miss range的终点
        for(int num : nums) {
            end = (long)num - 1;
            if(start == end) {
                res.add(String.valueOf(start));
            } else if(start < end) {
                res.add(String.valueOf(start) + "->" + String.valueOf(end));
            }
            start = (long)num + 1;
        }
        //处理可能剩余的末端range
        if(start < upper) {
            res.add(String.valueOf(start) + "->" + String.valueOf(upper));
        } else if(start == upper) {
            res.add(String.valueOf(start));
        }
        return res;
    }
}


public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int i = -1; i < nums.length; i++) {
            long left = (i == -1) ? (long)lower - 1 : nums[i];
            long right = (i + 1 == nums.length) ? (long)upper + 1: nums[i + 1];
            String temp = null;
            if(right == 2 + left) {
                temp = String.valueOf(right - 1);
            } else if(right > 2 + left) {
                temp = String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
            }
            if(temp != null) {
                res.add(temp);
            }
        }
        return res;
    }
}
