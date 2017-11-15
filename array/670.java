solution2:two pass, greedy, O(10n)
time: O(10n)
space: O(10)
记录0-9最靠右的位置。
扫描arr，看是否有大于自己，并且位置在自己右边的数。如果有交换即可。
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();

        int n = arr.length;
        int[] pos = new int[10];

        for(int i = 0; i < n; i++) {
            int key = arr[i] - '0';
            pos[key] = i;
        }

        for(int i = 0; i < n; i++) {//交换最左边的
            int key = arr[i] - '0';
            for(int j = 9; j > key; j--) {//与最大的最右边的数交换
                if(pos[j] > i) {
                    char temp = arr[i];
                    arr[i] = arr[pos[j]];
                    arr[pos[j]] = temp;
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }
}

solution1:选择排序的思想
只要有一次有效的swap就返回结果。
time: O(n^2)
space: O(n)
corner case:
98368
 |  |
1993
 ||
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();

        int n = arr.length;

        for(int i = 0; i < n; i++) {
            int max = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] >= arr[max]) {//取等号，尽量让后面的大数往前，前面的小数往后
                    max = j;
                }
            }
            if(max != i && arr[i] != arr[max]) {//前面去等号后，需要处理相同数的情况98368
                char temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
                break;
            }
        }

        s = new String(arr);
        return Integer.parseInt(s);
    }
}
