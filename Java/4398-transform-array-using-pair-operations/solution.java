class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sum1= 0;
        long sum2 = 0;
        for(int i=0; i< source.length; i++) {
            sum1 = sum1+ source[i];
        }
        for(int j = 0; j<target.length; j++) {
            sum2 = sum2 + target[j];
        }

        if(sum1 == sum2) return true;
        else return false;
    }
}
