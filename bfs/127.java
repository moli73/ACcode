//version 1: BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res = 0;
        HashSet<String> words = new HashSet<String>(wordList);

        if(words.contains(beginWord)){
             words.remove(beginWord);
        }


        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            res++;

            for(int k = 0; k < size; ++k){
                String word = q.poll();
                if(word.equals(endWord)){return res;}

                for(int i = 0; i < word.length(); ++i){
                    for(int j = 0; j < 26; ++j){
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, (char)('a' + j));
                        String next = new String(sb.toString());

                        if(!next.equals(word)){//this condition could delete, it always true when
                            if(words.contains(next)){//this is true, it cannot be same with word
                                words.remove(next);
                                q.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
