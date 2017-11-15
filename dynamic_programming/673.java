two pass
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        int max = 0;
        for(int i = 0; i < n; i ++) {
            len[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(len[i] < len[j] + 1) {//有更大的，就更新count
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    } else if(len[i] == len[j] + 1) {//有相同的，就累加count
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(max, len[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(len[i] == max) {
                res += count[i];
            }
        }
        return res;
    }
}

one pass
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
