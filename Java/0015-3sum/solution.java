class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // sort the array first to apply two pointers 
      
        for(int i = 0; i< nums.length; i++) {         

            if(i > 0 && nums[i] == nums[i-1]) continue; // duplicates with i
        
            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
             
                int sum = nums[i] + nums[left] + nums[right];
               
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                
                // duplicates skip with left
                while(left  < right && nums[left] == nums[left+1]){
                    left++;
                }
                // skip duplicated for right
                while(left < right && nums[right] == nums[right-1]){
                    right--;
                }  

                left++;
                right--;

                }
                else if(sum < 0){   // arrray sorted now so left++
                    left++;
                }

                else{
                    right--;
                }
            }
        }
        return result;
    }
}
