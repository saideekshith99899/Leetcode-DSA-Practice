class Solution {
    public int maxDistance(int[] position, int m) {

        //search space = low = 1, high = max(array)
        int low = 1;
        int high = 0;
        for(int i=0 ;i<position.length; i++) {
            if(position[i] > high) {
                high = position[i];
            }
        }
        Arrays.sort(position);
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(check(position, mid, m)) {
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
    
    return high;
        
    }

    private boolean check(int[] position, int mid, int m){
        int last_placed = position[0]; // sorted always first element 
        int count = 1; // on ball is placed na lastplaced so count = 1
        for(int i = 1; i < position.length; i++) {
            if(position[i] - last_placed >= mid) {
                count++;
                last_placed = position[i];
            }
        }

        if(count >= m) return true;
        else return false;
    } 
}
