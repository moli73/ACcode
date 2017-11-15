class Solution {
    public int trap(int[] height) {
        int right = height.length - 1;
        int left = 0;
        int bound = 0;//左右公用一个bound是可行的，初始为0，兜不住水
        int res = 0;
        while(left < right) {
            if(height[left] < height[right]) {   左边矮
                if(height[left] < bound) {      左边比bound矮，可以兜住水
                    res += bound - height[left];
                } else {
                    bound = height[left];      左边比bound高，兜不住水了，改变bound
                }
                left++;
            } else {
                if(height[right] < bound) {
                    res += bound - height[right];
                } else {
                    bound = height[right];
                }
                right--;
            }
        }
        return res;
    }
}

public class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, res = 0;
        int min = Math.min(height[left], height[right]);
        while(left < right) {
            if(height[left] < height[right]) {
                left++;
                if(height[left] < min) {
                    res += min - height[left];
                } else {
                    min = Math.min(height[left], height[right]);
                }
            } else {
                right--;
                if(height[right] < min) {
                    res += min - height[right];
                } else {
                    min = Math.min(height[left], height[right]);
                }
            }
        }
        return res;
    }
}
//九章答案更好
public class Solution {
    public int trapRainWater(int[] heights) {
        // write your code here
        int left = 0, right = heights.length - 1;
        int res = 0;
        if(left >= right)
            return res;
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                if(leftheight > heights[left]) {
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                right --;
                if(rightheight > heights[right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }
        return res;
    }
}
