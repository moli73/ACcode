class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) {
            return 0;
        }
        int max = 0;
        int count = 0;
        int[] len = new int[n];
        int[] cnt = new int[n];
        for(int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if(len[i] == len[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            if(len[i] > max) {
                max = len[i];
                count = cnt[i];
            } else if(len[i] == max) {
                count += cnt[i];
            }
        }
        return count;
    }
}
