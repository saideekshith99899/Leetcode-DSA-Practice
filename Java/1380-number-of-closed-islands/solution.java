class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(bfs(i,j,grid,visited))
                    count++;
                }
            }
        }
        return count;
    }
    public boolean bfs(int row, int col, int[][] grid, boolean[][] visited) {
        
        Queue<pair> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.offer(new pair(row,col));
        int[]  dr = {-1,1,0,0};
        int[]  dc = {0,0,-1,1};
        boolean closed = true;

        while(queue.size() > 0) {
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            if (r == 0 || c == 0 ||r == grid.length - 1 ||c ==grid[0].length-1) {
                closed = false;
            }
            for(int k=0; k<4;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >=0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                       && visited[nr][nc] == false && grid[nr][nc]==0) {
                        queue.offer(new pair(nr,nc));
                        visited[nr][nc] = true;
                }
            }
        }
        return closed;
    }
}
