class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int count1 = Integer.bitCount(num1);
        int count2 = Integer.bitCount(num2);
        if(count1 == count2) {
            return num1;
        }
        while (count1 > count2) {
            x &= (x - 1);
            count1--;
        }
        for (int i = 0; count1 < count2; i++) {
            if (((x >> i) & 1) == 0) {
                x |= (1 << i);
                count1++;
            }
        }
        return x;
    }
}
