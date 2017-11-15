//Sort + Two pointers
//time O(nlogn) n is max(n1, n2)  or  O(nlogn + mlogm + m + n)
//space O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] arr = new int[res.size()];
        for(int t = 0; t < arr.length; t++) {
            arr[t] = res.get(t);
        }
        return arr;
    }
}

//HashMap
//time: O(max(n1,n2))
//space: O(max(n1,n2))
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

        int[] arr = new int[res.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}


//sort + HashMap +binary search
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        if(nums1.length == 0) {
            return new int[0];
        }
        Arrays.sort(nums1);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for(int num : nums1) {
            if(!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        for(int num : nums2) {
            if(!map.containsKey(num) || map.get(num) <= 0) continue;

            if(check(nums1, num)) {
                map.put(num, map.get(num) - 1);
                res.add(num);
            }
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }

    private boolean check(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == k) {
                return true;
            }

            if(nums[mid] < k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if(nums[left] == k || nums[right] == k) {
            return true;
        } else {
            return false;
        }
    }
}
//other way is use the HashMap to store one array
//then scan the other array to check each element if comtain in the HashMap
What if the given array is already sorted? How would you optimize your algorithm?
only influence if we use the binary search solution

What if nums1's size is small compared to nums2's size? Which algorithm is better?


What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
external merge sort (sublist sort solution which I have learnt in database system course)
