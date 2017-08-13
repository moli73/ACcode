public class Solution {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L.length == 0 || k == 0) {
            return 0;
        }
        int start = 1, end = L[0];
        for(int len : L) {
            if(len > end) {
                end = len;
            }
        }

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(maxNum(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if(maxNum(L, end) >= k) {
            return end;
        } else if(maxNum(L, start) >= k) {
            return start;
        } else {
            return 0;
        }
    }

    public int maxNum(int[] L, int val) {
        int count = 0;
        for(int len : L) {
            count += len / val;
        }
        return count;
    }
}
