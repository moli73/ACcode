//trie + divide and conquer
public class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = makeTrie(words);

        for(String word : words) {
            if(word.length() == 0) continue;
            if(helper(root, word, 0)) {
                res.add(word);
            }
        }

        return res;
    }

    public boolean helper(TrieNode root, String word, int pos) {
        TrieNode ws = root;

        for(int i = pos; i < word.length(); i++) {
            if(ws.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            ws = ws.children[word.charAt(i) - 'a'];
            if(ws.word != null && !ws.word.equals(word)) {
                if(helper(root, word, i + 1)) {
                    return true;
                }
            }
        }
        return pos != 0 && ws.word != null;
    }

    class TrieNode {
        String word;
        TrieNode[] children = new TrieNode[26];
    }

    public TrieNode makeTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode ws = root;
            for(char c : word.toCharArray()) {
                if(ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode();
                }
                ws = ws.children[c - 'a'];
            }
            ws.word = word;
        }
        return root;
    }
}
