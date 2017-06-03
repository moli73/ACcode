public class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> hash = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < pid.size(); ++i){
            hash.put(pid.get(i), new ArrayList<Integer>());
        }
        for(int i = 0; i < ppid.size(); ++i){
            if(ppid.get(i) == 0) continue;
            hash.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        if(!hash.containsKey(kill)) return res;
        q.offer(kill);
        while(!q.isEmpty()){
            int cur = q.poll();
            res.add(cur);
            List<Integer> list = new ArrayList<Integer>();
            if(hash.containsKey(cur)){
                list = hash.get(cur);
                for(int i = 0; i < list.size(); ++i) q.offer(list.get(i));
            }
        }
        return res;
    }
}
