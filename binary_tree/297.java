/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //version 1: add parathese solution
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        String left = serialize(root.left);
        String right = serialize(root.right);
        String cur = new String();
        cur += root.val;
        if(left.length() == 0 && right.length() == 0) return cur;
        if(right.length() == 0) return cur + '(' + left + ')';
        return cur + '(' + left + ')' + '(' + right + ')';
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        int firstPar =data.indexOf('(');
        if(firstPar == -1){
            TreeNode root = new TreeNode(Integer.parseInt(data));
            return root;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, firstPar)));

        int leftParCount = 0;
        int lastPar = data.length() - 1;
        for(int i = firstPar; i < data.length(); ++i){
            if(data.charAt(i) == '(') leftParCount++;
            if(data.charAt(i) == ')') leftParCount--;
            if(leftParCount == 0){
                lastPar = i;
                break;
            }
        }

        root.left = deserialize(data.substring(firstPar + 1, lastPar));
        root.right = lastPar >= data.length() - 1 ? null : deserialize(data.substring(lastPar + 2, data.length() - 1));
        return root;
    }
}

//version 2: preorder traversal solution
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        int[] index = new int[1];
        return deserialize(index, nodes);
    }
    public TreeNode deserialize(int[] index, String[] nodes){
        if(index[0] >= nodes.length || nodes[index[0]].equals("X")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index[0]]));
        index[0]++;
        root.left = deserialize(index, nodes);
        root.right = deserialize(index, nodes);
        return root;
    }
}

//version 3: BFS traversal
//but TLE, using StringBuilder could pass OJ
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String data = new String();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return data;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur != null){
                data += cur.val + ",";
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else{
                data += "X,";
            }
        }
        return data;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(!nodes[index].equals("X")){
                cur.left = new TreeNode(Integer.parseInt(nodes[index++]));
                queue.offer(cur.left);
            } else{
                index++;
            }
            if(!nodes[index].equals("X")){
                cur.right = new TreeNode(Integer.parseInt(nodes[index++]));
                queue.offer(cur.right);
            } else{
                index++;
            }
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
