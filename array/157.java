/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int all = 0;
        while(all < n) {
            char[] buf4 = new char[4];
            int read = read4(buf4);

            int length = Math.min(n - all, read);//还需要read多少，和当前能read的多少取较小值，作为赋值长度。
            for(int i = 0; i < length && all < n; i++) {
                buf[all++] = buf4[i];
            }

            if(read < 4) {
                break;
            }//reset, treat as intermediate buf4
        }
        return all;
    }
}
