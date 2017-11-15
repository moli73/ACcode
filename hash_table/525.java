//初始化（0， -1）的版本
class Solution {
    public int findMaxLength(int[] nums) {
        /**
            treat zero to -1, and find subarray sum equals 0
        */
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int len = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(sum)) {
                if(i - map.get(sum) > len) {
                    len = i - map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }
        return len;
    }
}

//
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if(sum == 0) {
                res = i + 1;//单列了这个情况，就不用加入(0, -1)的pair了
            } else if(map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return res;
    }
}


//version
public class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int diff = 2 * sum - (i + 1);
            if(!map.containsKey(diff)) {
                map.put(diff, i);
            }
            if(diff == 0) {
                res = i + 1;
            } else {
                if(map.containsKey(diff)) {
                    res = Math.max(res, i - map.get(diff));
                }
            }
        }
        return res;
    }
}
