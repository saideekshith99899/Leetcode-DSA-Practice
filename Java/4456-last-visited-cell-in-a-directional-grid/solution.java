class Solution {
    public int[] lastVisitedCell(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    int row = 0;
    int col = 0;
    visited[row][col] = true;
        while(true){
            int nr = row;
            int nc = col;
            char dir = grid[row][col];
            if(dir == 'U') {
                nr--;
            }
            if(dir == 'D'){
                nr++;
            }
            if(dir == 'L'){
                nc--;
            }
            if(dir == 'R'){
                nc++;
            }
            if(nr < 0 || nc <0 || nr >= grid.length || nc >= grid[0].length || visited[nr][nc] == true) {
                break;
            }
            row = nr;
            col = nc;
            visited[row][col] = true;
        }
    return new int[]{row,col};
    }
}
