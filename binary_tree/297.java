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
        StringBuilder sb = new StringBuilder();
        helper(sb, root);
        return sb.toString();
    }
    private void helper(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("#,");
        } else {
            sb.append(String.valueOf(root.val)).append(",");
            helper(sb, root.left);
            helper(sb, root.right);
        }
    }

    private int pos = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return helper(arr);
    }

    public TreeNode helper(String[] arr) {
        if(pos >= arr.length || arr[pos].equals("#")) {
            pos++;//空节点也要move forward
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[pos]));
        pos++;
        root.left = helper(arr);
        root.right = helper(arr);
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



/*
      1
   2     3
  # #  4    5
      # #  #  #
string: 1, 2,3,#,#,4,5,#,#,#,#
利用Queue
*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(cur == null) {
                sb.append("#,");
            } else {
                sb.append(String.valueOf(cur.val)).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr.length == 0 || arr[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        for(int i = 1; i < arr.length; i++) {
            TreeNode cur = q.poll();

            if(!arr[i].equals("#")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.left);
            }
            i++;//关键的地方
            if(i < arr.length && !arr[i].equals("#")) {//注意判断越界
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.offer(cur.right);
            }

        }

        return root;
    }
}
