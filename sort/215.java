//quick select iteration version
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k + 1);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {//find k th smallest number
        if(start >= end) {
            return nums[start];
        }

        int mid = 0;
        for(;;) {
            mid = partition(nums, start, end);
            if(mid == k - 1) {
                break;
            } else if(mid < k - 1) {
                start = mid + 1;
            } else {//mid > k - 1
                end = mid - 1;
            }
        }

        return nums[mid];
    }

    private int partition(int[] nums, int start, int end) {
        Random random = new Random();
        int pivot = start + random.nextInt(end - start + 1);
        swap(nums, pivot, end);

        int i = start - 1;
        for(int j = start; j < end; j++) {
            if(nums[j] <= nums[end]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}

//PriorityQueue solution
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>(k + 1, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (int)(a - b);
            }
        });

        for(int num : nums) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        return pq.peek();
    }
}

//quick select recursion version
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);//第k大，就是第n - k + 1小
    }

    private int quickSelect(int[] nums, int left, int right, int k) {//find kth smallest
        int mid = partition(nums, left, right);
        if(mid == k - 1) {
            return nums[k - 1];
        }
        if(mid < k - 1) {
            return quickSelect(nums, mid + 1, right, k);
        } else {
            return quickSelect(nums, left, mid - 1, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left + 1) + left;
        swap(nums, pivot, right);

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
