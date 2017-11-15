class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int a = x >> i;
            int b = y >> i;
            if((a & 1) != (b & 1)) {
                res++;
            }
        }
        return res;
    }
}
