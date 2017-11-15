除了连续相同char一个的情况，不用copmress，
其余相同char都需要compress

38.count and say的双指针方法，并且记录一个当前string位置head
time: O(n)
space: O(1)
class Solution {
    public int compress(char[] chars) {
        int head = 0;
        int start = 0;
        int n = chars.length;

        while(start < n) {
            int i = start;

            while(i < n && chars[i] == chars[start]) {
                i++;
            }

            int count = i - start;
            if(count == 1) {
                chars[head++] = chars[start];

            } else {
                chars[head++] = chars[start];
                String cnt = String.valueOf(count);
                for(int k = 0; k < cnt.length(); k++) {
                    chars[head++] = cnt.charAt(k);
                }
            }
            start = i;
        }
        return head;
    }

}
