//bucket sort
//time O(n)
//space O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        /*
            1.use i position to store i;
            2.skip non-positive number and equal and larger than n
            3. if only one number, if it is 1 return 2, else return 1
        */
        if(nums == null || nums.length == 0) {

            return 1;

        }

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            while(nums[i] != i && nums[i] < n && nums[i] > 0 && nums[i] != nums[nums[i]]) {

                swap(nums, i, nums[i]);

            }

        }

        for(int i = 1; i < n; i++) {
            if(nums[i] != i) {
                return i;
            }
        }

        if(nums[0] == n) {
            return n + 1;
        }
        return n;
    }


    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}

//sort:
//time O(nlogn + n)
//space O(1)
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 1;//记录下一个应该出现的positive number
        for(int num : nums) {
            if(num == res) {
                res++;
            } else if(num > res) {
                return res;
            }
        }
        return res;
    }
}
