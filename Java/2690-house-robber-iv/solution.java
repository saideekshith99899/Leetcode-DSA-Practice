class Solution {
    public int minCapability(int[] nums, int k) {
        // search low =min , high = max 
     int low = 1;
     int high = 0;
     int ans = 0;
     for(int i =0; i<nums.length; i++) {
        if(nums[i] > high) {
            high = nums[i];
        }
     }
     while(low <= high) {
        int mid = low + (high - low)/2;
        if(check(nums,k,mid)){
            ans = mid;
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
     }
    return ans;
    }

    private boolean check(int[] nums, int k, int mid) {
        int count = 0;
        int i=0;
        while (i < nums.length){
            if(mid >= nums[i]){
                count++;
                i=i+2;
            }
            else{
                i=i+1;
            }
        }

        if(count >= k) return true;
        else return false;
    }
}
