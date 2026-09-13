class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] result = new int[grid.length][grid[0].length];
        int newColumn = 0;
        int newRow = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                newColumn = (j-rowShift[i] + n)%n;
                newRow = (i-colShift[newColumn] + n)%n;
                result[newRow][newColumn] = grid[i][j];
            }
        }
        return result;
    }
}
