class Solution {
    public int minFlips(int a, int b, int c) {
        int num = (a|b) ^ c;
        int result = (a&b);
        int num2 = (result & num);
        int count1 = Integer.bitCount(num);
        int count2 = Integer.bitCount(num2);
        return count1 + count2;
    }
}
