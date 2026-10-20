class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int start = image[sr][sc];
        if(start == color) return image;
        dfs(sr,sc,image,color,start);
        return image;
    }
    public void dfs(int row, int col, int[][] image, int color, int start){
        int m = image.length;
        int n = image[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || image[row][col] != start) {
        return;
        }
        image[row][col] = color;
        dfs(row-1,col,image,color,start);
        dfs(row+1, col, image,color,start);
        dfs(row,col-1,image,color,start);
        dfs(row,col+1,image,color,start);
    }
}
