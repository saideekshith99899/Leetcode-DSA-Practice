class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            if(i == 0 && nums[i] == 0) return i;
            int N = nums[i];
            int sum = 0;
            while(N != 0) {               
                int rem = N % 10;
                sum = sum + rem;
            
                N = N/10;
            }
                if(i == sum) return i;
        }
        return -1;
    }
}
