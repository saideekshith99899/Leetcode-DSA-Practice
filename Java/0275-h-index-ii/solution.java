class Solution {
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length - 1;
        int n = citations.length;
        int ans=0;
        while(low <= high) {
            int mid = low +(high - low)/2;
            if(check(citations, mid)) {
                ans = n - mid;
                high = mid -1;               
            }
            else{
                low = mid + 1;
            }
        }
        return ans;        
    }

    private boolean check(int[] citations, int mid){
        int n =citations.length;
       if(mid == n) return false;
       return citations[mid] >= n-mid;
    }
}
