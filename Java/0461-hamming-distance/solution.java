class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int count = Integer.bitCount(ans);
        return count;
    }
}
