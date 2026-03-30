class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0;     // left = l
        int sum = 0;
        double maxsum = -1000000;

        for(int r = 0; r < nums.length; r++){       // right = r
            sum = sum + nums[r];

            if(r - l + 1 == k)           
            {                       // r-l+1 i.e window size simply == k 
                                    // if true then shrinks and expand win size
             maxsum = Math.max(maxsum,sum);  
             sum = sum - nums[l];   // u need to remove nums[l] when u expand wn sz
             l++;                   // else u will get the sum of prev win size
                                //included  or remove prev sum element thats it     
            }
        }
        return maxsum/k;        
    }
}
