class Solution {
    public int uniquePaths(int[][] grid) {
        int mod = 1000000007;
        int m = grid[0].length;
        int[] dp =  new int[m];
        dp[0]=1;
        for(int[] row: grid) {
            int right  = 0;
            for(int j=0;j<row.length; j++) {
                if(row[j] == 1) {
                    int t = right;
                    right = dp[j];
                    dp[j] = t;
                }
                else{
                    right = dp[j] = (right + dp[j]) % mod;
                }
            }
        }
        return dp[dp.length-1];
    }
}
