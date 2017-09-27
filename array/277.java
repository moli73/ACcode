/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

//O(n + 2n) times knows function call
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) {
            if(knows(i, candidate) == false) {
                candidate = i;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i != candidate) {
                if(knows(i, candidate) == false || knows(candidate, i) == true) {
                    return -1;
                }
            }
        }
        return candidate;
    }
}
