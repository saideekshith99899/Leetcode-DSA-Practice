class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int row = 0; row<board.length; row++) {
            for(int col=0; col <board[0].length; col++) {
                if(find(board,word,row,col,0,used)){  // k = 0
                    return true;
                }
            }
        }
        return false;              
    }

    public boolean find(char[][] board, String word, int row, int col, int k, boolean[][]used){
        // base case
        if(k == word.length()) return true;
        // find the first char in board

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if(used[row][col]) {
            return false;
        }
        if(board[row][col] != word.charAt(k)) {
            return false;
        }
        used[row][col] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for(int d=0; d<4;d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

        if(find(board,word,newRow,newCol,k+1,used)){
            return true;
        }
        }
        used[row][col] = false;
        
    return false;
    }
}


