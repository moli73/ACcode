//version 1: O(n^L), n is the number words, and L is the length of word
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> comb = new ArrayList<String>();

        helper(res, comb, words, words[0].length());

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, String[] words, int n){
        if(comb.size() == n){
            res.add(new ArrayList<String>(comb));
            return;
        }

        for(int i = 0; i < words.length; i++){
            if(!isValid(comb, words[i])) continue;

            comb.add(words[i]);
            helper(res, comb, words, n);
            comb.remove(comb.size() - 1);
        }
    }

    public boolean isValid(List<String> comb, String cur){
        int row = comb.size();

        for(int i = 0; i < cur.length() && i < row; i++){
            if(cur.charAt(i) != comb.get(i).charAt(row)){
                return false;
            }
        }

        return true;
    }
}

//version 2: add Trie tree but to scan all trie tree leaves cost too much also TLE
public class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        TrieNode root = makeTrie(words);
        helper(res, new ArrayList<String>(), new String(), root);
        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, String prefix, TrieNode root) {
        if(comb.size() != 0 && comb.size() == comb.get(0).length()) {
            res.add(new ArrayList<String>(comb));
            return;
        }

        TrieNode ws = root;
        for(int i = 0; i < prefix.length(); i++) {
            if(ws.children[prefix.charAt(i) - 'a'] == null) {
                return;
            } else {
                ws = ws.children[prefix.charAt(i) - 'a'];
            }
        }

        List<String> next = getWords(ws);

        for(String word : next) {
            comb.add(word);

            String temp = new String();
            if(comb.size() != comb.get(0).length()) {
                for(int i = 0; i < comb.size(); i ++) {
                    temp += comb.get(i).charAt(comb.size());
                }
            }

            helper(res, comb, temp, root);
            comb.remove(comb.size() - 1);
        }
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public TrieNode makeTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode ws = root;
            for(int i = 0; i < word.length(); i++) {
                if(ws.children[word.charAt(i) - 'a'] == null) {
                    ws.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                ws = ws.children[word.charAt(i) - 'a'];
            }
            ws.word = word;
        }
        return root;
    }

    public List<String> getWords(TrieNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) {
            return res;
        }
        if(root.word != null) {
            res.add(root.word);
            return res;
        }

        for(int i = 0; i < 26; i++){
            res.addAll(getWords(root.children[i]));
        }

        return res;
    }
}
//version 3: add Trie Tree and startWith parameter of each TrieNode
public class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> startWith = new ArrayList<String>();
    }

    public TrieNode makeTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode ws = root;
            ws.startWith.add(word);

            for(char c : word.toCharArray()) {
                if(ws.children[c - 'a'] == null) {
                    ws.children[c - 'a'] = new TrieNode();
                }
                ws = ws.children[c- 'a'];
                ws.startWith.add(word);
            }
        }
        return root;
    }

    public List<String> search(TrieNode root, String prefix) {
        TrieNode ws = root;
        for(char c : prefix.toCharArray()) {
            if(ws.children[c - 'a'] == null) {
                return new ArrayList<String>();
            }
            ws = ws.children[c - 'a'];
        }
        return ws.startWith;
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        List<String> comb = new ArrayList<>();
        TrieNode root = makeTrie(words);

        helper(res, comb, root, new String(), words[0].length());

        return res;
    }

    public void helper(List<List<String>> res, List<String> comb, TrieNode root, String prefix, int n) {
        if(comb.size() == n) {
            res.add(new ArrayList<String>(comb));
            return;
        }

        List<String> next = search(root, prefix);

        for(String word : next) {
            comb.add(word);

            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < comb.size() && comb.size() < n; i++) {
                sb.append(comb.get(i).charAt(comb.size()));
            }

            helper(res, comb, root, sb.toString(), n);

            comb.remove(comb.size() - 1);
        }
    }
}
