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
        if(num >= 1000) {
            sb.append(helper(num / 1000, id + 1));
        }
        if(num % 1000 != 0) {
            sb.append(helper(num % 1000)).append(units[id]).append(" ");
        }
        return sb.toString();
    }

    private String helper(int num) {
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
