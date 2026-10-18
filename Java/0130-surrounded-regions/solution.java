class pair{
    int row;
    int col;
    pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0; i<m;i++) {
            if(board[i][0] == 'O'){
                bfs(i,0,board);
            }
            if(board[i][n-1] == 'O'){
                bfs(i,n-1,board);
            }
        }

        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O'){
                bfs(0,i,board);
            }
            if(board[m-1][i] == 'O'){
                bfs(m-1,i,board);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else {
                    board[i][j] = 'X';
                }
            }
        }
        
    }  

    public void bfs(int row, int col, char[][] board){
        Queue<pair> queue = new LinkedList<>();
        queue.offer(new pair(row,col));
        board[row][col] = '#';
        while(queue.size()>0) {
            pair cell = queue.poll();
            int r = cell.row;
            int c = cell.col;
            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};
            for(int k=0; k<4; k++){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr > 0 && nr < board.length && nc > 0 && nc < board[0].length
                 && board[nr][nc] == 'O') {
                    queue.offer(new pair(nr,nc));
                    board[nr][nc] = '#';
                 }
            }
        }

    }
}
