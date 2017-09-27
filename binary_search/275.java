//good binary search problem
//the judge condition is to compare the citations value and the number of the citations value bigger than this value
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) {
            return 0;
        }
        int left = 0, right = n - 1, mid = 0;
        while(left + 1 < right) {
            mid = left + (right - left) / 2;
            int count = n - mid;
            if(citations[mid] == count) {
                return count;
            } else if(citations[mid] <= count) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.max(Math.min(citations[left], n - left), Math.min(citations[right], n - right));
        //or
        // if(citations[left] < n - left) {
        //     return Math.min(citations[right], n - right);
        // } else {
        //     return Math.min(citations[left], n - left);
        // }
    }
}

//O(n) Solution
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        for(int i = 1; i <= n; i++) {
            if(citations[n - i] < i) {
                return i - 1;
            }
        }
        return n;
    }
}
