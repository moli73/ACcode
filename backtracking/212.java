class Solution {
    class TrieNode {
        TrieNode[] children;
        String word ;
        public TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    public TrieNode root;

    public void add(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
    }

    public void makeTrieTree(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            add(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null) {
            return res;
        }
        int m = board.length;
        if(m == 0) {
            return res;
        }
        int n = board[0].length;
        if(n == 0) {
            return res;
        }

        makeTrieTree(words);

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                helper(res, board, i, j, root);//不加判断的写法，会多递归一层才退出递归。
            }
        }
        return res;
    }

    public void helper(List<String> res, char[][] board, int i, int j, TrieNode root) {
        if(root == null) {
            return;
        }

        if(root.word != null) {
            res.add(root.word);
            root.word = null;//去重复
        }

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') {//坐标越界判断 和 已经visited过
            return;
        }

        char c = board[i][j];
        board[i][j] = '#';//标记visited

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        for(int k = 0; k < 4; k++) {
            helper(res, board, i + dx[k], j + dy[k], root.children[c - 'a']);
        }

        board[i][j] = c;//recover
    }
}
