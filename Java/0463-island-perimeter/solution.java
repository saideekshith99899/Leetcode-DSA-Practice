class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && !visited[i][j] ){
                    perimeter = bfs(i,j,grid,visited,perimeter);
                }
            }
        }
        return perimeter;
    }
    public int bfs(int row, int col, int[][] grid, boolean[][] visited, int perimeter){
        int m = grid.length;
        int n = grid[0].length;
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(row,col));
        visited[row][col] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(queue.size() > 0){
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            for(int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || grid[nr][nc] == 0) {
                perimeter++;
                }
                else if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new pair(nr, nc));
                }
            }
        }
        return perimeter;
    }
}
