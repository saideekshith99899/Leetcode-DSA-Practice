class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        int m = grid.length;
        int n= grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false){
                    int area = dfs(i,j,grid,visited);
                    max_area = Math.max(max_area,area);
                }
            }
        }
        return max_area;
    }
    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        int count = 1;
        if(row < 0|| col <0 || row >= grid.length || col >= grid[0].length 
                || visited[row][col] || grid[row][col] == 0){
            return 0;
        }
        visited[row][col] = true;
        
        count += dfs(row-1,col,grid,visited);
        count += dfs(row+1,col,grid,visited);
        count += dfs(row,col-1,grid,visited);
        count += dfs(row,col+1,grid,visited);

        return count;
    }
}
