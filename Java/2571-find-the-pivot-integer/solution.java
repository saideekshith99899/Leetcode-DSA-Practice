class Solution {
    public int pivotInteger(int n) {
        int total = n*(n+1) / 2;
        int leftsum = 0;
        int rightsum;
        for(int i=1;i<=n;i++) {
            leftsum += i;
            rightsum = total - leftsum + i;
            if(leftsum == rightsum) return i;
        }
        return -1;        
    }
}
