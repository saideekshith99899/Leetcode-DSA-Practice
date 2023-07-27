import java.util.*;
class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        int sum1=n*(n+1)/2;
      
        
     
         
         for(int i=0;i<nums.length ;i++)
         {
            sum=sum+nums[i];
         }


         return sum1 - sum;
    }
}
