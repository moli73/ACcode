/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        int n = nuts.length;
        qSort(nuts, bolts, compare, 0, n - 1);
    }
    public void qSort(String[] nuts, String[] bolts, NBComparator compare, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = partition(nuts, bolts, compare, start, end);
        qSort(nuts, bolts, compare, start, mid - 1);
        qSort(nuts, bolts, compare, mid + 1, end);
    }
    public int partition(String[] nuts, String[] bolts, NBComparator compare,
                int start, int end) {
        int i = start - 1;
        for(int j = start; j < end; j ++) {
            if(compare.cmp(nuts[end], bolts[j]) == 0) {
                swap(bolts, j, end);
            }//if match, swap to the end
            if(compare.cmp(nuts[end], bolts[j]) == 1) {
                i++;
                swap(bolts, i, j);
            }
        }
        swap(bolts, i + 1, end);//swap the match one to the right pos
        int res = i + 1;
        i = start - 1;
        for(int j = start; j < end; j++) {
            if(compare.cmp(nuts[j], bolts[res]) == 0) {
                swap(nuts, j, end);
            }
            if(compare.cmp(nuts[j], bolts[res]) == -1) {
                i++;
                swap(nuts, i, j);
            }
        }
        swap(nuts, i + 1, end);//swap the match one to the right pos
        return res;
    }
    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
};
