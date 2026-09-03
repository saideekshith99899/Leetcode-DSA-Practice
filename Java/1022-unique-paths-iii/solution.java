class Solution {
    public int uniquePathsIII(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        int startRow = 0;
        int startCol = 0;
        int rem = 0; // will find how many sqaures need to travel

        for(int row = 0; row<grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++){

                if(grid[row][col] != -1) rem++; // find empty squres

                if(grid[row][col] == 1){
                    // this is the starting point 
                    startRow = row;
                    startCol = col;
                }          
            }
        }
        return find(grid,startRow,startCol,used,rem);
    }

    public int find(int[][] grid, int row, int col, boolean[][] used, int rem) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return 0;
        }

        if(used[row][col]) return 0;

        if(grid[row][col] == -1) return 0;

        used[row][col] = true;
        rem--;

        if(grid[row][col] == 2) {
            if(rem == 0) {
                used[row][col] = false;
                return 1;
            }
        used[row][col] = false;
        return 0;
        }
    int count = 0;

    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,1,-1};
    for(int d= 0; d < 4; d++) {
        int newRow = row + dr[d];
        int newCol = col + dc[d];

        count = count + find(grid,newRow,newCol,used,rem);
    }
    used[row][col] = false;
    return count;
        
    }
}
