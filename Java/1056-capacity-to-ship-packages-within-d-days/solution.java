class Solution {
    public int shipWithinDays(int[] weights, int days) {
        //search space = low= max(weights) , high = sum(weights);
        int low = 0;
        for(int i=0;i<weights.length;i++) {
            if(weights[i] > low) {
                low = weights[i];
            }
        }
        int high;
        int sum = 0;
        for(int i=0 ;i < weights.length; i++) {
            sum = sum + weights[i];
        }
        high = sum;

        while(low <= high) {
            int mid = low + (high - low)/ 2;
            if(check(weights,mid,days)){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;


    }


    private boolean check (int[] weights, int mid , int days) {
        int days_needed = 1;
        int current_load = 0; // sum
        for(int i=0; i<weights.length; i++) {
            if(current_load + weights[i] > mid) { // sum 
                days_needed++;
                current_load = 0; //sum
            }
            current_load += weights[i];            
        }
        if(days_needed <= days) return true;
        else return false;
    }
}
