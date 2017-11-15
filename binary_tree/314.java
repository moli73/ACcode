//BFS solution with two pass
class Solution {
    class Item {
        TreeNode node;
        int index;
        public Item(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        helper(root, 0);
        List<List<Integer>> res  = new ArrayList<>();
        if(root == null) {
            return res;
        }
        for(int i = 0; i < -leftBound; i++) {
            res.add(new ArrayList<Integer>());
        }

        Queue<Item> q = new LinkedList<>();
        q.offer(new Item(root, -leftBound));

        while(!q.isEmpty()) {
            Item cur = q.poll();
            if(cur.index == res.size()) {
                res.add(new ArrayList<Integer>());
            }
            res.get(cur.index).add(cur.node.val);
            if(cur.node.left != null) {
                q.offer(new Item(cur.node.left, cur.index - 1));
            }
            if(cur.node.right != null) {
                q.offer(new Item(cur.node.right, cur.index + 1));
            }
        }
        return res;
    }



    private void helper(TreeNode root, int index) {
        if(root == null) {
            return;
        }
        if(leftBound > index) {
            leftBound = index;
        }
        helper(root.left, index - 1);
        helper(root.right, index + 1);
    }

    private int leftBound = 0;
}






//naive solution 
class Solution {
    private List<List<Integer>> left = new ArrayList<>();
    private List<List<Integer>> right = new ArrayList<>();//因为id肯定连续，如果用map做，可以直接存min，max，然后一次扫。不用key sorted

    class Pair {//还可以用两个同步的queue来实现。
        TreeNode node;
        int id;
        Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        left.add(new ArrayList<>()); //empty element

        //no need to record the level info, so no size in while loop
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            if(cur.id >= 0) {
                if(cur.id >= right.size()) {
                    right.add(new ArrayList<>());
                }
                right.get(cur.id).add(cur.node.val);
            } else {
                if(-cur.id >= left.size()) {
                    left.add(new ArrayList<>());
                }
                left.get(-cur.id).add(cur.node.val);
            }
            if(cur.node.left != null) q.offer(new Pair(cur.node.left, cur.id - 1));
            if(cur.node.right != null) q.offer(new Pair(cur.node.right, cur.id + 1));
        }

        for(int i = left.size() - 1; i > 0; i--) {
            res.add(new ArrayList<>(left.get(i)));
        }
        for(int j = 0; j < right.size(); j++) {
            res.add(new ArrayList<>(right.get(j)));
        }
        return res;
    }

}
