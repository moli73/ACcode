public class Solution {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int i = 0, j = chars.length - 1;
        while(i <= j) {
            while(i <= j && chars[i] >= 'a' && chars[i] <= 'z') i++;
            while(i <= j && chars[j] >= 'A' && chars[j] <= 'Z') j--;
            if(i <= j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;j--;
            }
        }
    }
}
