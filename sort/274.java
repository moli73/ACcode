class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for(int num : citations) {
            if(num > n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }

        int sum = 0;
        for(int i = n; i >= 0; i--) {
            sum += count[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
    }
}

//sort anwser
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for(int i = 1; i <= n; i++) {
            if(citations[n - i] < i) {
                return i - 1;
            }
        }
        return n;
    }
}
