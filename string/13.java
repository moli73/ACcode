class Solution {
    public int romanToInt(String s) {
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;
        int num = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            if(map[s.charAt(i) - 'A'] >= map[s.charAt(i + 1) - 'A']) {
                num += map[s.charAt(i) - 'A'];
            } else {
                num -= map[s.charAt(i) - 'A'];
            }
        }
        num += map[s.charAt(s.length() - 1) - 'A'];
        return num;
    }
}
