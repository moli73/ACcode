//sort and two pointers
//time complexity is O(nlogn)
//version1: 去重复取最后一个数
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

//hash map
//time O(max(n1, n2)) n1, n2是nums1和nums2数组长度。
//space O(max(n1, n2))
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums1) {
            set.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                set.remove(num);//key point
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

//binary search and hash set
//time O(nlogn)
//space O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length) {
            return intersection(nums2, nums1);
        }

        Arrays.sort(nums1);
        HashSet<Integer> res = new HashSet<Integer>();

        for(int num : nums2) {
            if(!res.contains(num)) {
                if(search(num, nums1)) {
                    res.add(num);
                }
            }
        }

        int n = res.size();
        int i = 0;
        int[] arr = new int[n];
        for(int num : res) {
            arr[i++] = num;
        }

        return arr;
    }

    private boolean search(int target, int[] nums) {
        if(nums.length == 0) return false;//key point
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

//version 2:去重复取第一个数，类似于backtracking去重的方法
public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] temp = new int[nums1.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || temp[index - 1] != nums1[i]) {
                    temp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = temp[k];
        }

        return result;
    }
}
