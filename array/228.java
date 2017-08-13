public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) {
            return res;
        }
        int left = 0, right = 0;
        for(right = 0; right < nums.length + 1; right++) {
            if(right == nums.length || right - left != nums[right] - nums[left]) {
                if(right - 1 != left) {
                    res.add(new String(String.valueOf(nums[left]) + "->" + String.valueOf(nums[right - 1])));
                } else {
                    res.add(new String(String.valueOf(nums[left])));
                }
                left = right;
            }
        }
        return res;
    }
}
//better code:
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        for(right = 0; right < nums.length; right++) {
            if(right + 1 == nums.length || nums[right] + 1 != nums[right + 1]) {//use next state to check类比LC56的代码类似。
                if(right != left) {
                    res.add(new String(String.valueOf(nums[left]) + "->" + String.valueOf(nums[right])));
                } else {
                    res.add(new String(String.valueOf(nums[left])));
                }
                left = right + 1;
            }
        }
        return res;
    }
}
