class Solution {
    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
       
        
        int[] leftsum = new int[n];
        int[] rightsum= new int [n];


        int sum=0;
        for(int i=0;i<n;i++){

           sum=sum+nums[i];
            leftsum[i] = sum;
            

        }
        
         sum=0;
         for(int i=n-1;i>=0;i--){

            sum=sum+nums[i];
            rightsum[i] = sum;
            

        }


        int[] result = new int[n];

        for(int i =0 ;i<n;i++){

            result[i] = Math.abs(leftsum[i] - rightsum[i]);
        }


        return result;

        
        
    }
}
