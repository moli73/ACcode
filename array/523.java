//HashMap better code
//time O(n)
//space O(n)
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}

//first time
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        if(k == 0) {
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] == 0 && nums[i + 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if(map.containsKey(remainder)) {
                if(i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
