class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0 && !visited[i][j])
                if(dfs(i,j,visited,grid)){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean dfs(int row, int col, boolean[][] visited, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return false;
        }
        if(grid[row][col] == 1 || visited[row][col] == true) return true;
        visited[row][col] = true;
        boolean up = dfs(row-1,col,visited,grid);
        boolean down = dfs(row+1,col,visited,grid);
        boolean left = dfs(row,col-1,visited,grid);
        boolean right = dfs(row,col+1, visited,grid);
        return up & down & left & right;
    }
}
