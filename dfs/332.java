//version 1: iteration + sort
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        for(String[] ticket : tickets) {
            String s = ticket[0], e = ticket[1];
            if(graph.containsKey(s)) {
                graph.get(s).add(e);
            } else {
                List<String> adjs = new ArrayList<>();
                adjs.add(e);
                graph.put(s, adjs);
            }
        }

        for(String s : graph.keySet()) {
            Collections.sort(graph.get(s), Collections.reverseOrder());
        }

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add("JFK");

        while(!stack.empty()) {
            String cur = stack.peek();//get the current node
            List<String> adjs = graph.get(cur);
            if(adjs != null && adjs.size() != 0) {
                String next = adjs.get(adjs.size() - 1);
                adjs.remove(adjs.size() - 1);//delete edge
                stack.add(next);
            } else {
                res.add(0, cur);
                stack.pop();
            }
        }

        return res;
    }
}
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> graph = new HashMap<>();

        for(String[] ticket : tickets) {
            String s = ticket[0], e = ticket[1];
            if(graph.containsKey(s)) {
                graph.get(s).add(e);
            } else {
                List<String> adjs = new ArrayList<>();
                adjs.add(e);
                graph.put(s, adjs);
            }
        }

        for(String s : graph.keySet()) {
            Collections.sort(graph.get(s), Collections.reverseOrder());
        }

        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add("JFK");//use the stack to do DFS

        while(!stack.empty()) {
            String cur = stack.peek();//get the current node
            List<String> adjs = graph.get(cur);
            if(adjs != null && adjs.size() != 0) {
                String next = adjs.get(adjs.size() - 1);
                adjs.remove(adjs.size() - 1);//delete edge
                stack.add(next);
            } else {
                res.add(0, cur);
                stack.pop();
            }
        }

        return res;
    }
}
//version 2: recursion version + priorityqueue
public class Solution {

    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());//取出字典序最小的，同时出队
        path.addFirst(departure);//倒序插入
    }
}
