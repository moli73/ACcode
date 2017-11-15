class Solution {
    private String[] under20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] under100 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] units = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        return helper(num, 0).trim();
    }

    private String helper(int num, int id) {
        StringBuilder sb = new StringBuilder();
        if(num >= 1000) { 如果大于1000，说明有更高级的数字，则先append，更高级的地方。先递归
            sb.append(helper(num / 1000, id + 1));
        }
        if(num % 1000 != 0) {   递归结束之后，append当前层的数字。
            sb.append(helper(num % 1000)).append(units[id]).append(" ");
        }
        return sb.toString();
    }

    private String helper(int num) {   对每一层的操作
        StringBuilder sb = new StringBuilder();
        if(num == 0) {//tricky point
            return "";
        } else if(num < 20) {
            sb.append(under20[num]).append(" ");
        } else if(num < 100){
            sb.append(under100[num / 10]).append(" ").append(helper(num % 10));
        } else {
            sb.append(under20[num / 100]).append(" ").append("Hundred ").append(helper(num % 100));
        }

        return sb.toString();
    }
}

class Solution {
    private String[] under20 = {"","One","Two", "Three","Four","Five","Six","Seven","Eight","Nine",
                            "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] under100 = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private String[] unit = {"","Thousand","Million","Billion"};

    public String numberToWords(int num) {
        if(num == 0) {
            return "Zero";
        }
        return helper(num, 0).trim();
    }

    public String helper(int num, int i) {
        if(num == 0) {
            return "";
        }
        if(num % 1000 == 0) {       如果当前层为0，就只做更高层。
            return helper(num / 1000, i + 1);
        }
        return helper(num / 1000, i + 1) + helper(num % 1000) + unit[i] + " ";  先做更高层，再链接当前层。
    }

    public String helper(int num) {   每个helper函数后都会带一个空格。
        if(num == 0) {
            return "";
        } else if(num < 20) {
            return under20[num] + " ";
        } else if(num < 100) {
            return under100[num / 10] + " " + helper(num % 10);
        } else {
            return helper(num / 100) + "Hundred " + helper(num % 100);
        }
    }
}
