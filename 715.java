class RangeModule {

    public Set<int[]> set;

    public RangeModule() {
        set = new HashSet<int[]>();
    }

    public void addRange(int left, int right) {
        int[] newRange = {left, right};
        mergeRange(set, newRange);
    }

    public void mergeRange(Set<int[]> set, int[] newRange) {
        for(int[] range : set) {
            if(newRange[1] < range[0] || newRange[0] > range[1]) {
                continue;
            } else {
                set.remove(range);
                newRange[0] = Math.min(range[0], newRange[0]);
                newRange[1] = Math.max(range[1], newRange[1]);
            }
        }
        set.add(newRange);
    }

    public boolean queryRange(int left, int right) {
        for(int[] range : set) {
            if(left >= range[0] && right <= range[1]) {
                return true;
            }
        }
        return false;
    }

    public void removeRange(int left, int right) {
        int[] deleteRange = {left, right};
        splitRange(set, deleteRange);
    }

    public void splitRange(Set<int[]> set, int[] deleteRange) {
        for(int[] range : set) {
            if(deleteRange[1] < range[0] || deleteRange[0] > range[1]) {
                continue;
            } else {
                set.remove(range);
                if(deleteRange[0] <= range[0] && deleteRange[1] >= range[1]) {
                    continue;
                } else if(deleteRange[0] > range[0] && deleteRange[1] < range[1]) {

                    int[] temp1 = new int[2];
                    temp1[0] = range[0];
                    temp1[1] = deleteRange[0];
                    set.add(temp1);

                    int[] temp2 = new int[2];
                    temp2[0] = deleteRange[1];
                    temp2[1] = range[1];
                    set.add(temp2);

                } else {
                    int[] temp = new int[2];
                    temp[0] = Math.max(range[0], deleteRange[0]);
                    temp[1] = Math.min(range[1], deleteRange[1]);
                    set.add(temp);
                }
            }
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
