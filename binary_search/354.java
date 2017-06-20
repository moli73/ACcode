public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]) return b[1] - a[1];
                else return a[0] - b[0];
            }
        });
        int[] tails = new int[n + 1];
        tails[0] = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0; i < n; ++i){
            int left = 0, right = res;
            while(left + 1 < right){
                int mid = left + (right - left) / 2;
                if(tails[mid] < envelopes[i][1]) left = mid;
                else right = mid;
            }
            if(tails[right] < envelopes[i][1]){
                res++;
                tails[res] = envelopes[i][1];
            } else{
                tails[right] = envelopes[i][1];
            }
        }
        return res;
    }
}
