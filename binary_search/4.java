//the time complexiy is O(log(m + n))
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(((m + n) & 1) == 0) return ((double)findKthNumber(nums1, nums2, 0, 0, (m + n) / 2) + (double)findKthNumber(nums1, nums2, 0, 0, (m + n) / 2 + 1)) / 2;
        else return (double)findKthNumber(nums1, nums2, 0, 0, (m + n) / 2 + 1);
    }
    public int findKthNumber(int[] nums1, int[] nums2, int s1, int s2, int k){
        //if one array is null
        if(nums2.length - s2 == 0) return nums1[s1 + k - 1];
        if(nums1.length - s1 == 0) return nums2[s2 + k - 1];
        //recursion base condition
        if(k == 1) return nums1[s1] < nums2[s2] ? nums1[s1] : nums2[s2];
        //elimination others, keep the less part
        if(nums2.length - s2 < k / 2) return findKthNumber(nums1, nums2, s1 + k / 2, s2, k - k /2);
        if(nums1.length - s1 < k / 2) return findKthNumber(nums1, nums2, s1, s2 + k / 2, k - k /2);
        //compare the specific element
        if(nums1[s1 + k / 2 - 1] < nums2[s2 + k / 2 - 1]) return findKthNumber(nums1, nums2, s1 + k / 2, s2, k - k /2);
        else return findKthNumber(nums1, nums2, s1, s2 + k / 2, k - k /2);
    }
}
