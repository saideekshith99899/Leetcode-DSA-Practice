class Solution {
    public int numIslands(char[][] grid) {
        int count_island = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    count_island++;
                    dfs(i,j, grid, visited);
                }
            }
        }
        return count_island;
    }    
    public void dfs(int row, int col, char[][] grid, boolean[][] visited) {
    
    if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || grid[row][col] == '0' || visited[row][col] == true) {
        return;
    }
    visited[row][col] = true;
    dfs(row-1,col,grid,visited);
    dfs(row+1,col,grid,visited);
    dfs(row,col-1,grid,visited);
    dfs(row,col+1,grid,visited);
    }
}
