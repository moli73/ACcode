//Sort + Two pointers
//time O(nlogn) n is max(n1, n2)
//space O(1)
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

//sort + HashMap +binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums2);
        for(int num : nums2) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int num : nums1) {
            if(map.containsKey(num) && map.get(num) > 0) {
                if(search(num, nums2)) {
                    map.put(num, map.get(num) - 1);
                    res.add(num);
                }
            }
        }

        int n = res.size();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private boolean search(int target, int[] nums) {
        if(nums.length == 0) {
            return false;
        }

        int left = 0, right = nums.length - 1, mid = 0;
        while(left + 1 < right) {
            mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left] == target || nums[right] == target) {
            return true;
        } else {
            return false;
        }
    }
}

//HashMap
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums1) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        List<Integer> res = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                res.add(num);
            }
        }

        int n = res.size();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = res.get(i);
        }

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
