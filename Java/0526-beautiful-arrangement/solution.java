class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        find(n,used,1);
        return count;
    }
    public void find(int n, boolean[] used, int start) {
        // base case
        if(start > n){
            count++;
            return;
        }
        for(int i=1; i<=n;i++){
            if(used[i]) continue;                     
            if(i % start == 0 || start % i == 0) {
            used[i] = true;
            find(n,used,start+1);
            used[i] = false;
            }
        }
    }
}
