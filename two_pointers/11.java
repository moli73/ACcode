class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1, res = 0;
        while(i < j) {
            if(height[i] < height[j]) {
                if(res < height[i] * (j - i)) {
                    res = height[i] * (j - i);
                }
                i++;
            } else {
                if(res < height[j] * (j - i)) {
                    res = height[j] * (j - i);
                }
                j--;
            }
        }
        return res;
    }
}
