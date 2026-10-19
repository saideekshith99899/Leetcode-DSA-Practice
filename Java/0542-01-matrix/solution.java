class pair {
    int row;
    int col;
    pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;        
        Queue<pair> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0){
                    ans[i][j] = 0;
                    queue.offer(new pair(i,j));
                }
                else{
                    ans[i][j] = -1;
                }
            }
        }
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(queue.size() > 0){
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            for(int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nc >= 0 && nr <m && nc < n && ans[nr][nc] == -1){
                    queue.add(new pair(nr,nc));
                    ans[nr][nc] = ans[r][c] + 1;
                }
            }
        }
        return ans;
    }
}
