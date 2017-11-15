/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buf4 = new char[4];
    private int read = 0;
    private int i = 0;

    public int read(char[] buf, int n) {
        int all = 0;
        for(; i < read && all < n; i++) {
            buf[all++] = buf4[i];
        }

        while(all < n) {
            read = read4(buf4);

            int length = Math.min(n - all, read);

            for(i = 0; i < length && all < n; i++) {
                buf[all++] = buf4[i];
            }

            if(read < 4) {
                break;
            }
        }

        return all;
    }
}


/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] buf4 = new char[4];
    private int i = 0;//当前读到了buf4的哪个位置
    private int read = 0;//buf4中有几个char
    public int read(char[] buf, int n) {
        int size = 0;//buf中已经读了多少个char
        for(; i < read && size < n; i++) {
            buf[size++] = buf4[i];
        }
        while(size < n) {
            read = read4(buf4);
            if(read == 0) break;

            int len = Math.min(n - size, read);//本次loop，buf还能读几个char

            for(i = 0; i < len; i++) {
                buf[size++] = buf4[i];
            }
        }
        return size;
    }
}
/**

every time read buf4 first then do read4


*/
