class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; 
        int high = 0;
        for(int i=0 ; i<piles.length ; i++) {
            if(piles[i] > high) {    // high = max value in nums
                high = piles[i];
            }
        }    

        while(low <= high) {       
            int mid = low +(high - low) /2;
            if(check(piles,mid,h)) {
                high = mid - 1;
            }
            else{
                low = mid +1;
            }
        }
        return low;
    }

    private boolean check(int[] piles, int mid, int h){
        long sum = 0;
        for(int i=0 ;i <piles.length; i++) {
            sum = sum + ((piles[i] + mid - 1)/ mid);
        }
        return sum <=h;
    }
}
