class WordDictionary {
	class TrieNode {
		boolean isWord = false;
		TrieNode[] children;
		public TrieNode() {
		children = new TrieNode[26];
    }

}

    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(cur.children[c - 'a'] == null) {
                cur.children[c- 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int pos, TrieNode root) {
        if(root == null) {
            return false;
        }

        if(pos == word.length()) {
            return root.isWord;
        }

        if(word.charAt(pos) != '.') {
            return helper(word, pos + 1, root.children[s.charAt(pos) - 'a']);
        }

        for(int i = 0; i < 26; i++) {
            if(helper(word, pos + 1, root.children[i])) {
                return true;
            }
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
