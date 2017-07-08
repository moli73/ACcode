public class WordDictionary {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd;
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i ++){
            if(ws.children[word.charAt(i) - 'a'] == null){
                ws.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            ws = ws.children[word.charAt(i) - 'a'];
        }

        ws.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    
    //version 1:
    public boolean helper(TrieNode root, String word, int pos) {//divide and conquer, 带参数的helper
        if(root == null) {
            return false;
        }
        if(pos == word.length()) {
            return root.isEnd;
        }

        boolean res = false;

        if(word.charAt(pos) == '.'){
            for(int i = 0; i < 26; i++){
                res |= helper(root.children[i], word, pos + 1);
            }
        } else {
            if(root.children[word.charAt(pos) - 'a'] == null){
                res = false;
            } else {
                res = helper(root.children[word.charAt(pos) - 'a'], word, pos + 1);
            }
        }
        return res;
    }

    //version 2:
    public boolean helper(TrieNode root, String word, int pos) {
        if(root == null) {
            return false;
        }
        if(pos == word.length()) {
            return root.isEnd;
        }

        if(word.charAt(pos) == '.'){
            for(int i = 0; i < 26; i++){
                if(root.children[i] != null){
                    if(helper(root.children[i], word, pos + 1)){//tricky, only helper is true, return true; otherwise, continue;
                        return true;
                    }
                }
            }
        } else {
            return helper(root.children[word.charAt(pos) - 'a'], word, pos + 1);
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
