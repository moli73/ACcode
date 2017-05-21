//sort and two pointers
//time complexity is O(nlogn)
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(i < nums1.length && j < nums2.length){
            while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
            while(j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] arr = new int[res.size()];
        for(int k = 0; k < res.size(); ++k) arr[k] = res.get(k);
        return arr;
    }
}
//if use binary search, also need to sort one array first
//since the sorted array is the first condition of the binary search
