/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {return null;}
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        return helper(visited, node);
    }

    public UndirectedGraphNode helper(Map<UndirectedGraphNode, UndirectedGraphNode> visited,
                                     UndirectedGraphNode s) {
        if(visited.containsKey(s)) {
            return visited.get(s);
        }

        UndirectedGraphNode cur = new UndirectedGraphNode(s.label);
        visited.put(s, cur);

        for(UndirectedGraphNode adj : s.neighbors) {
            cur.neighbors.add(helper(visited, adj));
        }

        return cur;
    }
}
