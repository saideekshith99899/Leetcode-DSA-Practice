class Solution {
    public int findPeakElement(int[] nums) {
       int low =0;
       int high = nums.length - 1;
       while(low < high) { // l<=h not can do mid and mid+1 if equal
        int mid = low+(high - low)/2;
        if(nums[mid] < nums[mid+1]){ // right side go else left side
            // u can choose left or right always peak u find
            // because of -inf and -inf boundaries many peaks can presnt
            low = mid+1;
        }
        else{
            high = mid;
        }
       }
       return low;
    }
}
