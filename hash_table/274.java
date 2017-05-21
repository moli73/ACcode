//sort, O(nlogn)
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length, res = 0;
        if(n == 0 || citations[n - 1] == 0) return 0;
        for(int i = 0; i < n; ++i){
            if(citations[i] != 0){
                res = Math.max(res, Math.min(citations[i], n - i));
            }
        }
        return res;
    }
}
//hash table
//O(n)
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        //if(n == 0) return n;
        int[] count = new int[n + 1];
        for(int i = 0; i < n; ++i){
            if(citations[i] >= n) count[n]++;
            else count[citations[i]]++;
        }
        int total = 0;
        for(int i = n; i >= 0; --i){
            total += count[i];
            if(total >= i) return i;
        }
        return 0;
    }
}
