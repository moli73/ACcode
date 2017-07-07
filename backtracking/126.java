public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();

        Set<String> words = new HashSet<String>(wordList);
        words.remove(beginWord);

        List<String> path = new ArrayList<String>();
        path.add(beginWord);

        Queue<List<String>> q = new LinkedList<List<String>>();//tricky is to stall the list into queue
        q.offer(path);

        while(!q.isEmpty()){
            if(res.size() != 0) break;//once find the anwser, no need to search

            int size = q.size();
            Set<String> preWords = new HashSet<String>(words);//to record the fromer set

            for(int k = 0; k < size; ++k){
                List<String> cur = q.poll();

                String word = cur.get(cur.size() - 1);
                if(endWord.equals(word)){
                    res.add(cur);
                    continue;
                }

                for(String next : getNext(word)){
                    if(preWords.contains(next)){//use former set to check the exsitence
                            words.remove(next);
                            List<String> nextPath = new ArrayList<String>(cur);
                            nextPath.add(next);
                            q.offer(nextPath);
                    }
                }
            }
        }
        return res;
    }

    public List<String> getNext(String word){
        List<String> next = new ArrayList<String>();
        for(int i = 0; i < word.length(); ++i){
            for(int j = 0; j < 26; ++j){
                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i, (char)('a' + j));
                next.add(sb.toString());
            }
        }
        return next;
    }
}
