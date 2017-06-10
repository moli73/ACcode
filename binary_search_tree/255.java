public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        return helper(0, preorder.length - 1, preorder);
    }
    public boolean helper(int start, int end, int[] preorder){
        if(start >= end) return true;
        int mid = end + 1;
        for(int i = start + 1; i <= end; ++i){
            if(mid == end + 1){
                if(preorder[start] < preorder[i]) mid = i;
            }
            else{
                if(preorder[start] > preorder[i]) return false;
            }
        }
        boolean left = helper(start + 1, mid - 1, preorder);
        boolean right = helper(mid, end, preorder);
        return left && right;
    }
}
