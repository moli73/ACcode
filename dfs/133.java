/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

 //DFS
public class Solution {
	private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) {
			return null;
		}
		if(map.containsKey(node)) {
			return map.get(node);
		}

        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);

        for(UndirectedGraphNode adj : node.neighbors) {
			copy.neighbors.add(cloneGraph(adj));
		}

        return copy;
	}
}

//BFS:
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        q.offer(node);

        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode adj : cur.neighbors) {
                if(!map.containsKey(adj)) {
                    map.put(adj, new UndirectedGraphNode(adj.label));
                    q.offer(adj);
                }
                map.get(cur).neighbors.add(map.get(adj));
            }
        }

        return map.get(node);
    }
}
