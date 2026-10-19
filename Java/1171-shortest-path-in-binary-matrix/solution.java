class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;
        return bfs(0,0,grid,visited); // bfs(0,0)
    }
    public int bfs(int row, int col, int[][] grid, boolean[][] visited) {

        int distance = 1; // (0,0) cell also count so dist = 1 
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(row,col));
        visited[row][col] = true;
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1,  0,  1,-1, 1,-1, 0, 1}; 
        while(queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            if(r == m-1 && c == n-1) return distance;
            for(int k=0; k<8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n  && visited[nr][nc] == false && grid[nr][nc] == 0) {
                    queue.add(new pair(nr,nc));
                    visited[nr][nc] = true;
                }
            }
        }
        distance++;
        }
        return -1;
    }
}
