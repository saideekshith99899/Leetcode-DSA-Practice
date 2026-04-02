class Solution {
    public int[] decrypt(int[] code, int k) {

        int[] result = new int[code.length];
        int n = code.length;
        int sum = 0;

        if(k == 0) return result;

        if(k>0) {
            for(int i = 1; i<=k; i++) {
                sum = sum + code[i % n];      // initial window 2,3,4 elements
        }

        for(int i = 0; i<n; i++) {
            result[i] = sum;

            sum = sum - code[((i+1) % n)];   // remove 

            sum = sum + code[(i+k+1) % n];    // add circular

        }
}
        else
        {
            k = -k;

            for(int i=1;i<=k;i++) {
                sum = sum+code[(n-i)%n];
            }

            for(int i=0;i<n;i++) {
                result[i] = sum ;
                sum = sum - code[(n+i-k)%n]; // remove 
                sum = sum + code[(i%n)];     // add 
            }

        }
        return result;           
        
    }
}
