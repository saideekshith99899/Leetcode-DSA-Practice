class Solution {
    public int reverseBits(int n) {
     int result = 0;
     for(int i=0; i<32; i++) {
        result = result << 1;  // rem 
        result = result | (n & 1); // sum = sum * 10 + rem;
        n = n >> 1;           // n = n/2
     }
     return result;

    }
}
