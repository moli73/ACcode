public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length == 0) {
            return res;
        }
        res.add(nums[0]);

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){//每个数，去看是否能整出前面的数，并且个数更多，然后编程当前位置可有最长subset

            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);

            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && subsets.get(j).size() + 1 > cur.size()){
                    cur = new ArrayList<Integer>(subsets.get(j));
                    cur.add(nums[i]);
                }
            }
            if(cur.size() > res.size()){//找到最长的subset
                res = cur;
            }
            subsets.add(new ArrayList<Integer>(cur));

        }

        return res;
    }
}
现在的做法，计算i位置的subset，利用到了前面i - 1位置的subset情况，很有子问题的感觉。
subsets[i]表示，以nums[i]结尾的最长的subset

Given a set of integers that satisfies the property that each pair of integers inside the set are mutually divisible,
for a new integer S,
1.S can be placed into the set as long as it can divide the smallest number of the set
2.or S is divisible by the largest number of the set.

after sort， 我们就可以只考虑加入一个能整出前面subset中最大的数情况下的数
