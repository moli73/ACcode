public class PhoneDirectory {
    int[] hash;
    int count;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        hash = new int[maxNumbers];
        count = 0;
        for(int i = 0; i < maxNumbers; ++i){
            hash[i] = 1;
        }
        count = maxNumbers;
    }

    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(count < 1) { return -1;}
        for(int i = 0; i < hash.length; ++i){
            if(hash[i] == 1){
                hash[i] = 0;
                count--;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return hash[number] == 1;
    }

    /** Recycle or release a number. */
    public void release(int number) {
        hash[number] = 1;
        count++;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
