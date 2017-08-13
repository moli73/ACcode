public class Trie {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isLeaf;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;

        for(int i = 0; i < word.length(); i++){
            if(ws.children[word.charAt(i) - 'a'] == null){//is not null means, the that char exists
                ws.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            ws = ws.children[word.charAt(i) - 'a'];
        }

        ws.isLeaf = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            if(ws.children[word.charAt(i) - 'a'] == null){
                return false;
            }
            ws = ws.children[word.charAt(i) - 'a'];
        }

        return ws.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++){
            if(ws.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            ws = ws.children[prefix.charAt(i) - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
