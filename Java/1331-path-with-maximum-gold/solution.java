class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        boolean[][] used = new boolean[grid.length][grid[0].length];
        for(int row = 0; row<grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
            int result =  find(grid,row,col,used,max);
            max = Math.max(max,result);
            }
        }
        return max;
    }

    public int find(int[][] grid, int row, int col, boolean[][] used, int max){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if(grid[row][col] == 0) return 0;
        if(used[row][col]) return 0;

        used[row][col] = true;
        int gold = grid[row][col];
        int maxGold = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};
        for(int d = 0; d < 4; d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

           int result =  gold + find(grid,newRow,newCol,used,max);
           maxGold = Math.max(maxGold,result);
        } 
        used[row][col] = false;
        return maxGold;
    }
}
