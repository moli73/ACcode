更好的if条件判断：
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        /*
        用当前的status作为第一分类，再用前面的status作为分类
        1.start:
            之前是start:时间差记录到stack peek上
            之前是end:时间差记录到stack peek上
            push new id
            更新时间起点为ts
        2.end:
            之前是start:时间差记录到stack peek上
            之前是end:时间差记录到stack peek上
            pop peek
            更新时间起点为ts + 1，因为第ts秒已经被占用。
        */
        Stack<Integer> stack = new Stack<>();
        int start = -1;//record the start time of next function call

        for(String log : logs) {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            boolean isStart = arr[1].equals("start");
            int ts= Integer.parseInt(arr[2]);

            if(isStart) {
                if(!stack.empty()) {
                    res[stack.peek()] += ts - start;
                }
                start = ts;
                stack.push(id);
            } else {
                res[stack.pop()] += ts - start + 1;
                start = ts + 1;   十分trikcy，刚好符合end前一个是start（同一个function），或者end前一个是end（另一个function）的情况
            }
        }

        return res;

    }
}


// first solution
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        /*log analyze:
        1.start, start,  res[i - 1] += ts[i] - ts[i - 1]
        2.start, end, res[i - 1] += ts[i] - ts[i - 1] + 1, must be same function
        3.end, end, res[i] += ts[i] - ts[i - 1], nested function
        4.end, start, 检查是否有母函数，属于母函数的时间

        */
        int lastID = -1;
        boolean lastStatus = false;
        int lastTS = -1;
        Stack<Integer> stack = new Stack<>();

        for(String curLog : logs) {
            String[] log = curLog.split(":");
            int id = Integer.parseInt(log[0]);
            boolean status = log[1].equals("start") ? true : false;
            int ts = Integer.parseInt(log[2]);

            if(lastID != -1) {
                if(lastStatus) {
                    if(status) {//current start
                        res[lastID] += ts - lastTS;
                        stack.push(id);
                    } else {//current end
                        res[lastID] += ts - lastTS + 1;
                        stack.pop();
                    }
                } else {
                    if(status) {//current start
                        if(!stack.empty()) {
                            res[stack.peek()] += ts - lastTS - 1;
                        }
                        stack.push(id);
                    } else {//current end
                        res[id] += ts - lastTS;
                        stack.pop();
                    }
                }
            } else {
                stack.push(id);
            }

            lastID = id;
            lastStatus = status;
            lastTS = ts;
        }

        return res;

    }
}
