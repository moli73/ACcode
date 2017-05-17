//binary search , time complexity is O(nlogn)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0, start = 1, end = numbers.length - 1, mid;
        int[] res = new int[2];
        for(first = 0; first < numbers.length - 1; ++first){
            start = first + 1; end = numbers.length - 1;
            while(start + 1 < end){
                mid = start + (end - start) / 2;
                if(numbers[mid] + numbers[first] == target){
                    res[0] = first + 1;
                    res[1] = mid + 1;
                    return res;
                }
                else if(numbers[mid] + numbers[first] > target) end = mid;
                else start = mid;
            }
            if(numbers[start] + numbers[first] == target){
                res[0] = first + 1;
                res[1] = start + 1;
                return res;
            }
            else if(numbers[end] + numbers[first] == target){
                res[0] = first + 1;
                res[1] = end + 1;
                return res;
            }
        }
        return res;
    }
}
//two pointers, time complexity is O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            else if(numbers[left] + numbers[right] > target) right--;
            else left++;
        }
        return res;
    }
}
