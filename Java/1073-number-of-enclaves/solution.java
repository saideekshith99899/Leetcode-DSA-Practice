import java.util.*;

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                bfs(i, 0, grid, visited);
            }
            if (grid[i][n - 1] == 1 && !visited[i][n - 1]) {
                bfs(i, n - 1, grid, visited);
            }
        }       
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                bfs(0, j, grid, visited);
            }
            if (grid[m - 1][j] == 1 && !visited[m - 1][j]) {
                bfs(m - 1, j, grid, visited);
            }
        }   
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int row, int col, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) {
                    continue;
                }
                if (grid[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}
