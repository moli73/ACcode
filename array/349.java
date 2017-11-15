//sort and two pointers
//time complexity is O(nlogn)
//version1: 去重复取最后一个数
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            //pick last unique number
            while(i + 1 < nums1.length && nums1[i] == nums1[i + 1]) i++;
            while(j + 1 < nums2.length && nums2[j] == nums2[j + 1]) j++;
            //退出loop时候，要么是最后一个数，要么是相同数字的最后一个
            int num1 = nums1[i];
            int num2 = nums2[j];

            if(num1 == num2) {
                res.add(num1);
                i++;
                j++;
            } else if(num1 > num2) {
                j++;
            } else {
                i++;
            }
        }

        int[] arr = new int[res.size()];
        for(int k = 0; k < res.size(); k++) {
            arr[k] = res.get(k);
        }
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

//hash map
//time O(max(n1, n2)) n1, n2是nums1和nums2数组长度。
//space O(min(n1, n2))
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1) {
            set.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for(int num : nums2) {
            if(set.contains(num)) {
                set.remove(num);
                res.add(num);
            }
        }

        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
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

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return intersection(nums2, nums1);//保证被排序，被二分的是大数组
        }
        if(nums1.length == 0) {//如果nums1为空，则二分法越界，直接return空
            return new int[0];
        }
        Arrays.sort(nums1);

        Set<Integer> set = new HashSet<Integer>();
        List<Integer> res = new ArrayList<Integer>();

        for(int num : nums2) {
            if(set.contains(num)) continue;

            if(check(nums1, num)) {
                res.add(num);
                set.add(num);//注意加入set
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
            if(nums[mid] == k) return true;

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
