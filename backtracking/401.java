public class Solution {
    private int[] nums = {1, 2, 4, 8, 16, 32};
    public List<String> readBinaryWatch(int num) {
        List<List<String>> hours = new ArrayList<>();
        List<List<String>> mins = new ArrayList<>();
        makeHour(hours, 0, 0, 3, 0);
        makeMin(mins, 0, 0, 5, 0);

        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= num && i < hours.size(); ++i){
            for(int j = 0; j < hours.get(i).size(); ++j){
                if(num - i < mins.size()){
                    for(int k = 0; k < mins.get(num - i).size(); ++k){
                        String cur = new String(hours.get(i).get(j));
                		cur += ':';
                        cur += mins.get(num - i).get(k);
                        res.add(cur);
                    }
                }
            }

        }
        return res;
    }

    public void makeHour(List<List<String>> hours, int cur, int start, int end, int level){
        if(cur > 11){
            return;
        }
        String temp = new String(Integer.toString(cur));
        if(level == hours.size()){
            List<String> next = new ArrayList<String>();
            next.add(temp);
            hours.add(new ArrayList<String>(next));
        } else {
            hours.get(level).add(temp);
        }

        for(int i = start; i <= end; ++i){
            cur += nums[i];
            makeHour(hours, cur, i + 1, end, level + 1);
            cur -= nums[i];
        }
    }

    public void makeMin(List<List<String>> mins, int cur, int start, int end, int level){
        if(cur > 59){
            return;
        }
        String temp = new String(Integer.toString(cur));
        if(cur < 10){
            temp = '0' + temp;
        }
        if(level == mins.size()){
            List<String> next = new ArrayList<String>();
            next.add(temp);
            mins.add(new ArrayList<String>(next));
        } else {
            mins.get(level).add(temp);
        }

        for(int i = start; i <= end; ++i){
            cur += nums[i];
            makeMin(mins, cur, i + 1, end, level + 1);
            cur -= nums[i];
        }
    }
}
//better code
public class Solution {
    private int[] nums = {1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int k = 0; k <= num; ++k){
            List<Integer> hours = new ArrayList<>();
            helper(hours, 0, 0, 4, k);

            List<Integer> mins = new ArrayList<>();
            helper(mins, 0, 0, 6, num - k);

            for(int hour : hours){
                if(hour > 11) { continue; }
                for(int min : mins){
                    if(min > 59) { continue; }

                    res.add(hour + ":" + (min < 10 ? "0" + min : min));
                }
            }
        }

        return res;
    }

    public void helper(List<Integer> res, int comb, int pos, int end, int count){
        if(count == 0){
            res.add(comb);
            return;
        }

        for(int i = pos; i < end; ++i){
            helper(res, comb + nums[i], i + 1, end, count - 1);
        }
    }
}

// version 2: bit manipulation
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int h = 0; h < 12; h++){
            for(int m = 0; m < 60; m++){
                if(Integer.bitCount(h) + Integer.bitCount(m) == num){
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }
}
