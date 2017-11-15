corner case:
1.0.0.0.0 和 1.0是相同的
1.0000 和 1.0是相同的
1.001 和 1.000001是相同的

solution 1: split
time: O(n)
space: O(n)
http://www.runoob.com/java/java-string-split.html
split() 方法根据匹配给定的正则表达式来拆分字符串。
注意： 点.    或| 和 星* 等转义字符，必须得加 \\。
注意：多个分隔符，可以用 | 作为连字符。

“1111”.split("\\.")    ---->结果是 {“1111”}
Integer.parseInt("00001") ----> 结果是1

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i = 0;
        int j = 0;
        while(i < arr1.length || j < arr2.length) {
            int num1 = 0;
            int num2 = 0;
            if(i < arr1.length) {
                num1 = Integer.parseInt(arr1[i++]);
            }

            if(j < arr2.length) {
                num2 = Integer.parseInt(arr2[j++]);
            }
            if(num1 < num2) {
                return -1;
            }
            if(num1 > num2) {
                return 1;
            }
        }
        return 0;
    }
}
