public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if(pages.length == 0) {
            return 0;
        }
        int start = 1, end = 0;
        for(int page : pages) {
            end += page;
        }
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(numOfPeople(pages, mid) <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(numOfPeople(pages, start) <= k) {
            return start;
        } else {
            return end;
        }
    }

    public int numOfPeople(int[] pages, int mid) {
        int count = 0;
        int i = 0;
        while(i < pages.length) {
            if(pages[i] > mid) {
                return Integer.MAX_VALUE;
            }
            count++;
            int cur = 0;
            while(i < pages.length && cur + pages[i] <= mid) {
                cur += pages[i];
                i++;
            }
        }
        return count;
    }
}
