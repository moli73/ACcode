class Solution {
// place the tasks in row-order:
// then frame size is (count[25] - 1) * (n - 1) + 25 - i
// we just need to compare the frame size with the tasks size
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        while(i >= 0 && count[i] == count[25]) {
            i--;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }
}
