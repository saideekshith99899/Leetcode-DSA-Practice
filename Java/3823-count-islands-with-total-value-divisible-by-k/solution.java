class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n= grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0 && !visited[i][j]){
                    long sum = dfs(i,j,grid, visited);
                    if(sum % k == 0) count++;
                }
            }
        }
        return count;
    }
    public long dfs(int row, int col, int[][] grid, boolean[][] visited){
        int m = grid.length;
        int n = grid[0].length;
        if(row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == 0 || visited[row][col]) {
            return 0;
        }
        long sum = grid[row][col];
        visited[row][col] = true;
        sum += dfs(row-1,col,grid,visited);
        sum += dfs(row+1,col,grid,visited);
        sum += dfs(row,col-1,grid,visited);
        sum += dfs(row,col+1,grid,visited);
        return sum;
    } 
}
