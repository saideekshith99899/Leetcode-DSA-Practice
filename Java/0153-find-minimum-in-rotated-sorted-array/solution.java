class Solution {
    public int findMin(int[] nums) {
        
        int low = 0; 
        int high = nums.length - 1;
        while(low < high) {
            int mid = low+(high - low)/2; 
            // one side always sorted left / right check mid
            if(nums[mid] > nums[high]){  // sorted 2nd half
                low = mid + 1;
            }
            else {
                high = mid; 
// mid - 1 means u r missing mid  , not checking == mid case thats y we direct mention in else case high = mid
            }
        }
        return nums[low]; // min ele always at low index
    }
}
