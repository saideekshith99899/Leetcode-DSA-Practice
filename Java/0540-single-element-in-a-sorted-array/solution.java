class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        // edge case if only 1 element return itself
        if(nums.length == 1) return nums[0];
        while(low < high) {
            int mid = low + (high - low)/2;
            if(mid % 2 == 0) { //even index 
                if(nums[mid] == nums[mid+1]) {
                    //mid and mid+1 equal- right side single element
                    low = mid+2;
                }
                else{
                    high = mid;
                }
            }
            else{ // odd index
                mid--;
                if(nums[mid] == nums[mid+1]){
                    low = mid+2;
                }
                else{
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}
