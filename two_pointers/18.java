public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for(int m = 0; m < nums.length; m++) {
            if(m != 0 && nums[m] == nums[m - 1]) continue;
            for(int n = m + 1; n < nums.length; n++) {
                if(n != m + 1 && nums[n] == nums[n - 1]) continue;
                int i = n + 1, j = nums.length - 1;
                while(i < j) {
                    if(nums[i] + nums[j] + nums[m] + nums[n] == target) {
                        List<Integer> comb = new ArrayList<>();
                        comb.add(nums[i]);
                        comb.add(nums[j]);
                        comb.add(nums[m]);
                        comb.add(nums[n]);
                        res.add(new ArrayList<Integer>(comb));
                        i++;
                        j--;
                    } else if(nums[i] + nums[j] + nums[m] + nums[n] > target) {
                        j--;
                    } else {
                        i++;
                    }
                    while(i < j & i != n + 1 && nums[i] == nums[i - 1]) i++;
                    while(i < j && j != nums.length - 1 && nums[j] == nums[j + 1]) j--;
                }
            }
        }
        return res;
    }
}
