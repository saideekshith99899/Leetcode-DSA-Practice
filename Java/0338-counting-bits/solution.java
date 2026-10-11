class Solution {
    public int[] countBits(int n) {
    int[] result = new int[n+1];
    int num = 0;
    int j = 0;
    while(num <= n){
        int count = 0;
        for(int i=0 ; i<32; i++) {
            if(((num >> i) & 1) == 1)  {
                count++;
            }
        }
        result[j] = count; 
        num++;
        j++;
    }
    return result;
    }
}
