class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for(String item : bank) {
            set.add(item);
        }
        if(!set.contains(end)) return -1;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        set.remove(start);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int k = 0; k < size; k++) {
                String cur = q.poll();
                List<String> adjs = findAdjs(cur, set);
                for(String adj : adjs) {
                    if(adj.equals(end)) {
                        return count;
                    }
                    q.offer(adj);
                }
            }
        }
        return -1;
    }


    public List<String> findAdjs(String cur, Set<String> set) {
        char[] gene = {'A', 'C', 'G', 'T'};
        List<String> res = new ArrayList<>();
        for(int i = 0; i < cur.length(); i++) {
            for(int j = 0; j < gene.length; j++) {
                if(gene[j] != cur.charAt(i)) {
                    StringBuffer sb = new StringBuffer(cur);
                    sb.setCharAt(i, gene[j]);
                    if(set.contains(sb.toString())) {
                        res.add(sb.toString());
                        set.remove(sb.toString());
                    }
                }
            }
        }
        return res;
    }
}
