class Solution {
    public void moveZeroes(int[] nums) {
        int n=nums.length;
        int nonzeros=0;
        for(int i=0;i<n;i++){
           if(nums[i]!=0){
               nums[nonzeros] = nums[i];
               nonzeros++;
           }
           }

           while(nonzeros < n){

               nums[nonzeros]=0;
               nonzeros++;
           }
        
    }
}
