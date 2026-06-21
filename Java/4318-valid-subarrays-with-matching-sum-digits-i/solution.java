class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int count = 0;
        int n = nums.length;
        long[] prefix = new long[n+1];
        prefix[0] = 0;
        for(int i=0; i< n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        for(int i=0; i< n; i++) {
            for(int j = i; j < n; j++) {
                long sum = prefix[j+1] - prefix[i];
                int firstdigit = 0, lastdigit = 0;
                long temp;
                temp = sum;    
                lastdigit = (int) (temp % 10);
                    while(temp >= 10) {                       
                        temp = temp / 10;
                    }
                firstdigit = (int)temp ;
                if(firstdigit == x && lastdigit == x) count++;                 }
        }        
    return count;
    }
} 
