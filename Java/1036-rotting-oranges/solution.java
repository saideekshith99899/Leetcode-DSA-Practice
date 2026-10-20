class pair{
    int row;
    int col;
    pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0; // count fresh oranges in grid
        Queue<pair> queue = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2){
                    queue.offer(new pair(i,j));
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            } 
        }
        return bfs(grid,queue,fresh);
    }
    public int bfs(int[][] grid, Queue<pair> queue, int fresh){
        boolean rotten = false;
        int time = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(queue.size() > 0 && fresh > 0){
            int size = queue.size();
            for(int i=0; i<size; i++) {
                pair cell = queue.poll();
                int r = cell.row;
                int c = cell.col;
                for(int k=0; k<4; k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length){
                        continue;
                    }
                    if(grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        rotten = true;
                        queue.offer(new pair(nr,nc));
                    }
                }
            }
            if(rotten) time++;
        }
        return (fresh > 0) ? -1:time;
    }
}
