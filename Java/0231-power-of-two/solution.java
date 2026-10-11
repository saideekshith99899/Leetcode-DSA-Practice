class Solution {
    public boolean isPowerOfTwo(int n) {
    int count  = 0;
    if( n < 0) return false;
    String binary = Integer.toBinaryString(n);
    for(int i=0; i<binary.length(); i++) {
        char ch = binary.charAt(i);
        if(ch == '1') count++;
    }
    return count == 1;
    }
}
