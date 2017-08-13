public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if(nums == null) return null;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        map.put(0,-1);//前缀和初始值为0，脚标-1
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            if(map.containsKey(sum)){
                result.add(map.get(sum)+1);
                result.add(i);
                return result;
            }
            map.put(sum, i);
        }
        return result;

    }
}
