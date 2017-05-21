//good binary search problem
//the judge condition is to compare the citations value and the number of the citations value bigger than this value
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if(n == 0) return 0;
        int start = 0, end = n - 1, mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(citations[mid] <= n - mid) start = mid;
            else end = mid;
        }
        return Math.max(Math.min(citations[start], n - start), Math.min(citations[end], n - end));
    }
}
