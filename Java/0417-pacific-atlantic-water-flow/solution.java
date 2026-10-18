class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> list = new ArrayList<>();
    int m = heights.length;
    int n = heights[0].length;
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            boolean[][] pacific = new boolean[m][n];
            boolean[][] atlantic = new boolean[m][n];
            if(dfs(i,j,heights,pacific,-1,-1)) {
                if(dfs(i,j,heights,atlantic,m,n)){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
    }
    return list;    
    }
    public boolean dfs(int row, int col, int[][] heights, boolean[][] visited, int oceanRow, int oceanCol) {
        int m = heights.length;
        int n = heights[0].length;
        if(oceanRow == -1 && (row == 0 || col == 0)) {
            return true;
        }
        if(oceanRow == m && (row == m-1 || col == n-1)){
            return true;
        }
        visited[row][col] = true;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        for(int k=0; k<4; k++) {
            int nr = row + dr[k];
            int nc = col + dc[k];
            if(nr >=0 && nr < m && nc >= 0 && nc < n
                    && !visited[nr][nc]
                    && heights[nr][nc] <= heights[row][col]){
                        if(dfs(nr,nc,heights,visited,oceanRow,oceanCol))
                        {
                            return true;
                        }
                    }
        }
        return false;
    }
}
