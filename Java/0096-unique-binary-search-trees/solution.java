class Solution {
    public int numTrees(int n) {
        long result = 1;
        for(int i=1;i<=n;i++) {
            result = result * (n+i) / i;
        }
        return (int) (result/(n+1));
   
    }
}
