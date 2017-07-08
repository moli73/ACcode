public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = makeTrie(words);
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper(res, new String(), i, j, board, root);
            }
        }
        return res;
    }

    public void helper(List<String> res, String comb, int i, int j, char[][] board, TrieNode root){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.'){
            return;
        }//越界，或者已扫描，就退出递归

        char c = board[i][j];
        comb += c;
        root = root.children[c - 'a'];//在当前层，移动一下root。之前root指向父亲节点。
        if(root == null) {
            return;
        } else if(root.isEnd) {
            res.add(comb);
            root.isEnd = false;//de-duplicate
        }

        board[i][j] = '.';//进入下一层之前，清空

        helper(res, comb, i - 1, j, board, root);
        helper(res, comb, i + 1, j, board, root);
        helper(res, comb, i, j - 1, board, root);
        helper(res, comb, i, j + 1, board, root);

        board[i][j] = c;//返回上一层之前，还原
        comb = comb.substring(0, comb.length() - 1);
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    public TrieNode makeTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++){
                if(ws.children[word.charAt(i) - 'a'] == null) {
                    ws.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                ws = ws.children[word.charAt(i) - 'a'];
            }
            ws.isEnd = true;
        }
        return root;
    }

}
