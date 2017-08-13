public class Solution {
	/**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int i = 0, j = nums.length - 1;
	    while(i <= j) {
	        if(nums[i] < k) {
	            i++;
	        } else {
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            j--;
	        }
	    }
	    return i;
    }
}
//version 2: jiuzhang answer
public class Solution {
	/**
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int i = 0, j = nums.length - 1;
	    while(i <= j) {
	        while(i <= j && nums[i] < k) {
	            i++;
	        }
	        while(i <= j && nums[j] >= k) {
	            j--;
	        }
	        if(i <= j) {
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            j--;
	            i++;
	        }
	    }
	    return i;
    }
}
