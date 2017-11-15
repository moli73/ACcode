class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int left = nums[0];
        int right = 0;
        for(int num : nums) {
            right += num;
            left = Math.max(num, left);
        }

        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(check(nums, m, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if(check(nums, m, left)) {
            return left;
        } else {
            return right;
        }
    }

    private boolean check(int[] nums, int m, int bound) {
        int count = 0;
        long sum = 0;//最关键的地方
        for(int num : nums) {
            sum += num;
            if(sum > bound) {//每当当前sum > bound,     特别的如果当前数，大于bound，会count一直累加到n，n是数组长度。
                sum = num;//下一次sum为这次的数，
                count++;//则计数1.
                if(count >= m) {//去等于是因为下次还的占一个位置。
                    return false;
                }
            }
        }
        return true;//说明可分
    }
}
