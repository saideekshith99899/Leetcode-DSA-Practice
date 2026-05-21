class Solution {
    public long repairCars(int[] ranks, int cars) {
        //search space = low 1 , high = max(array) do all cars reapir
        long low = 1;
        long max = 0;
        long high;
        for(int i=0; i<ranks.length; i++) {
            if(ranks[i] > max){
                max = ranks[i]; 
            }
        }
        high = max * cars * cars;
        long ans=0;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(check(ranks, cars, mid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] ranks, int cars, long mid) {
        long sum = 0;
        for(int i=0; i< ranks.length; i++) {
            sum = sum + (long)Math.sqrt((double)mid / ranks[i]);
        }

        if(sum >= cars) return true;
        else return false;
    }
}
