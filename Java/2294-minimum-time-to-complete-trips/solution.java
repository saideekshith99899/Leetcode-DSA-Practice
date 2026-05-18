class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        //search space
        // low = 1, high = max * totaltrips
     long low = 1;
     long high;
     int max= 0; 
     for(int i=0; i<time.length; i++) {
        if(time[i] > max) {
            max = time[i];
        }
     }
     high = (long)max * totalTrips;
     while(low <= high)   {
        long mid = low + (high - low)/2;
        if(check(time, mid ,totalTrips)){
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
     }
     return low;
    }

    private boolean check(int[] time, long mid , int totalTrips) {
        long sum = 0;
        for(int i=0; i<time.length; i++) {

            sum = sum + (mid / time[i]);
            
        }

        if(sum >= totalTrips) return true;
        else return false;
    }
}
