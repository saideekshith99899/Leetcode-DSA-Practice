import java.util.*;
class Solution {
    public int countKDifference(int[] nums, int k) {
        int count=0;

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){
                int y = Math.abs(nums[i]-nums[j]);
                if(y == k){
                    count++;
                }
            }
        }
        return count;
    }
}
