class pair {
    int row;
    int col;
    pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestBridge(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    boolean found = false; // Find the first island
    boolean[][] visited = new boolean[m][n];
    Queue<pair> queue = new LinkedList<>();
        for(int i=0; i<m && !found; i++) {
            for(int j=0; j<n && !found; j++) {
                if(grid[i][j] == 1) {
                    dfs(i,j,grid,visited,queue);
                    found = true;
                }
            }
        }   
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int distance = 0;
        while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            for(int k=0; k<4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) {
                continue;
            }
            if(grid[nr][nc] == 1) {
                return distance;
            }
            visited[nr][nc] = true;
            queue.offer(new pair(nr, nc));
        }
    }
        distance++;
    }
    return -1;
}
public void dfs(int r, int c, int[][] grid,
                    boolean[][] visited, Queue<pair> queue) {

        int m = grid.length;
        int n = grid[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n
            || visited[r][c] || grid[r][c] == 0) {
            return;
        }

        visited[r][c] = true;
        queue.offer(new pair(r, c));

        dfs(r - 1, c, grid, visited, queue);
        dfs(r + 1, c, grid, visited, queue);
        dfs(r, c - 1, grid, visited, queue);
        dfs(r, c + 1, grid, visited, queue);
    }
}
