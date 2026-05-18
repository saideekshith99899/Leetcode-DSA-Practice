class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > high) {
                high = nums[i];
            }
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(check(nums, mid, threshold)) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] nums, int mid, int threshold) {
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum = sum + ((nums[i] + mid - 1)/ mid);
            // ceil value ceil(nums[i]/mid);           
        }
        if(sum <= threshold) return true;
        else return false;
    }
}
