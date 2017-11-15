/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
注意binary search考虑没有答案的情况。
如果存在没有答案的情况，那么最后return 要分left，right，无答案三种情况讨论。
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if(isBadVersion(left)) {
            return left;
        } else {
            return right;
        }
    }
}
