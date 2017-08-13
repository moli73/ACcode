public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res  = new ArrayList<Integer>();
        int i= 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                ++i; ++j;
            }
            else if(nums1[i] > nums2[j]) ++j;
            else i++;
        }
        int[] arr = new int[res.size()];
        for(int k = 0; k < res.size(); ++k) arr[k] = res.get(k);
        return arr;
    }
}
//other way is use the HashMap to store one array
//then scan the other array to check each element if comtain in the HashMap
What if the given array is already sorted? How would you optimize your algorithm?
only influence if we use the binary search solution

What if nums1's size is small compared to nums2's size? Which algorithm is better?


What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
external merge sort (sublist sort solution which I have learnt in database system course)
