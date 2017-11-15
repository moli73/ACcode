分析：
将排序后，
前一半数，越大的数字，放在越小的odd index
后一半数，越小的数字，放在越大的even index
这样才能，将中间部分的数字尽可能的分开，不相邻。

如果先sort数组，
1.升序sort
前一半先对m，镜像，然后 * 2
后一半，先镜像，然后 * 2， 然后都错一位。
2.降序sort
1.翻倍，错一位，间隔一个数 2.偶数mod len + 1, 奇数mod len能够把较小数放到指定位置
能够把两部分的map统一：nums[(2 * i + 1) % (n | 1)] = copy[i]

========best solution=======
descending sort + partition + sort color
time: O(n)
space:O(1)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int m = (n + 1) / 2;//指向median右边第一个数（odd个数），或者右边median（even个数）

        int median = findKthSmallestNumber(nums, m);//找到的是最终中间的那个数

        int i = 0;
        int left = 0;
        int right = n - 1;
        while(i <= right) {
            if(nums[map(i, n)] > median) {
                swap(nums, map(i++, n), map(left++, n));
            } else if(nums[map(i, n)] < median) {
                swap(nums, map(i, n), map(right--, n));
            } else {
                i++;
            }
        }

    }

    private int map(int i, int n) {
        return (2 * i + 1) % (n | 1);
    }

    private int findKthSmallestNumber(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        for(;;) {
            mid = partition(nums, left, right);
            if(mid == k - 1) {
                break;
            }

            if(mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, right, pivot);

        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(nums[j] <= nums[right]) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

solution 1：sort 升序，copy数组，分两半，分别map
time：O(nlogn)
space: O(n)
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = (n + 1) / 2;//指向median右边第一个数（odd个数），或者右边median（even个数）
        int[] copy = new int[n];
        for(int i = 0; i < n; i++) {
            copy[i] = nums[i];
        }
        Arrays.sort(copy);

        for(int i = 0; i < m; i++) {//整个左半边的map，包括median（odd个数）
            nums[2 * (m - 1 - i)] = copy[i];
        }

        for(int i = m; i < n; i++) {
            nums[2 * (n - 1 - i) + 1] = copy[i];
        }

    }
}

sort 降序
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int m = (n + 1) / 2;//指向median右边第一个数（odd个数），或者右边median（even个数）
        int[] copy = new int[n];
        Arrays.sort(nums);
        //descending sort
        for(int i = 0; i < n; i++) {
            copy[n - i - 1] = nums[i];
        }


        for(int i = 0; i < n; i++) {
            nums[(2 * i + 1) % (n | 1)] = copy[i];//1.翻倍，错一位，间隔一个数 2.偶数mod len + 1, 奇数mod len能够把较小数一部分归位
        }
    }
}

solution 2: quick select + mapping
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int m = (n + 1) / 2;//指向median右边第一个数（odd个数），或者右边median（even个数）
        int[] copy = new int[n];
        int median = findKthSmallestNumber(nums, m);//找到的是最终中间的那个数

        for(int j = 0; j < n; j++) {
            copy[j] = nums[j];
        }
        //to partition(sort color)
        int i = 0;
        int left = 0;
        int right = n - 1;
        while(i <= right) {     相等也要执行
            if(copy[i] < median) {
                swap(copy, i++, left++);
            } else if(copy[i] > median) {
                swap(copy, i, right--);
            } else {
                i++;
            }
        }

        for(i = 0; i < m; i++) {//整个左半边的map，包括median（odd个数）
            nums[2 * (m - 1 - i)] = copy[i];
        }

        for(i = m; i < n; i++) {
            nums[2 * (n - 1 - i) + 1] = copy[i];
        }
    }

    private int findKthSmallestNumber(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        for(;;) {
            mid = partition(nums, left, right);
            if(mid == k - 1) {
                break;
            }

            if(mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, right, pivot);

        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(nums[j] <= nums[right]) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

sort 降序
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;

        int m = (n + 1) / 2;//指向median右边第一个数（odd个数），或者右边median（even个数）
        int[] copy = new int[n];
        int median = findKthSmallestNumber(nums, m);//找到的是最终中间的那个数

        for(int j = 0; j < n; j++) {
            copy[j] = nums[j];
        }

        //to partition(sort color)
        int i = 0;
        int left = 0;
        int right = n - 1;
        while(i <= right) {    相等也要执行   case: [1,1,1,4,5,6] median = 1
            if(copy[i] > median) {
                swap(copy, i++, left++);
            } else if(copy[i] < median) {
                swap(copy, i, right--);
            } else {
                i++;
            }
        }

        for(i = 0; i < n; i++) {
            nums[(2 * i + 1) % (n | 1)] = copy[i];//1.翻倍，错一位，间隔一个数 2.偶数mod len + 1, 奇数mod len能够把较小数一部分归位
        }
    }

    private int findKthSmallestNumber(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        for(;;) {
            mid = partition(nums, left, right);
            if(mid == k - 1) {
                break;
            }

            if(mid < k - 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[k - 1];
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, right, pivot);

        int i = left - 1;
        for(int j = left; j < right; j++) {
            if(nums[j] <= nums[right]) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
