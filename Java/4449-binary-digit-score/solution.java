class Solution {
    public int calculateScore(int a, int b) {
        int count1 = Integer.bitCount(a);
        int count2 = Integer.bitCount(b);
        if(count1 >= count2){
            return count1 * count2;
        }
        return count2/count1;
    }
}
