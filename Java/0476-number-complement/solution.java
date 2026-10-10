class Solution {
    public int findComplement(int num) {
        int bits = 32 - Integer.numberOfLeadingZeros(num);
        // bits = length of num (in bits = 3) (32- 29)
        int mask = (1 << bits) - 1;  // all ones
        return ~ num & mask;
    }
}
