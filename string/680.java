stackoverflow recursion
class Solution {
    public boolean validPalindrome(String s) {
        boolean skip = false;
        return helper(s, 0, s.length() - 1, skip);
    }

    public boolean helper(String s, int left, int right, boolean skip) {
        if(left > right) {
            return true;
        }
        if(s.charAt(left) == s.charAt(right)) {
            return helper(s, left + 1, right - 1, skip);
        } else {
            if(skip == true) {
                return false;
            } else {
                skip = true;
                return helper(s, left + 1, right, skip) || helper(s, left, right - 1, skip);
            }
        }
    }
}

two pointers solution
time O(n)
space O(1)
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return helper(s, left + 1, right) || helper(s, left, right - 1);
            }
        }
        return true;
    }

    public boolean helper(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}
