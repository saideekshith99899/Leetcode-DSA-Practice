class Solution {
    public int differenceOfSum(int[] nums) {
        int result = 0;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        

         
            for(int i=0;i<nums.length;i++){

                int num = nums[i];
                while(num!=0){
                int rem = num% 10;
                result+=rem;
                num = num/10;
            }

            
        
        }
        return  Math.abs(sum-result);
        
    }  
}
