class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] > high) {
                high = bloomDay[i];
            }
        }
        // edge case return -1
        int n = bloomDay.length;
        if(m > n/k) return -1;

        while(low <= high) {
            int mid = low+(high - low) / 2;

            if(check(bloomDay,mid,m,k)) {
                high = mid - 1 ;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean check(int[] bloomDay,int mid, int m, int k) {
        int count = 0;
        int bouquets = 0;
        for(int i=0; i<bloomDay.length; i++) {
            if(bloomDay[i] <= mid) {
                count++;
                if(count == k) {
                    bouquets++;
                   count = 0;
              }  
            } 
            else {
                count = 0;
            }  
                               
        }

    return bouquets >= m;
    }
}
