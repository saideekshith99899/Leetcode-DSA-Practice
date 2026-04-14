class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i=0; i<n;i++) {       // fill result = -1 all index
            result[i] = -1;
        }

        int windowsize = 2*k+1;        // 3 + center + 3 = 7 => 2k+1;
        int left = 0;
        long sum = 0;

        for(int right = 0; right< nums.length; right++) {

            sum = sum + nums[right];

            if(right-left+1 == windowsize){   // 7 = 7 then do sum -> avg
                int mid = left + k;
                result[mid] = (int)(sum / windowsize);  // store ans in result mid 

                sum = sum - nums[left];
                left++;            
            }
        }

        return result;
        
    }
}
