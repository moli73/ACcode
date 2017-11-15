class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int res = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {

                count++;

                if(res == -1) {//第一个数，直接放进reservior
                    res = i;
                } else {//后面的数，就要进行random的swap了
                    Random random = new Random();
                    int index = random.nextInt(count);

                    if(index == 0) {
                        res = i;
                    }
                }
            }
        }
        return res;
    }
}
