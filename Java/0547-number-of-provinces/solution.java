class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n]; // false
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                dfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }

    public void dfs(int i, boolean[] visited, int[][] isConnected) {
        visited[i] = true;
        for(int j = 0; j<isConnected.length; j++) {
            if(isConnected[i][j] == 1 && visited[j] == false) {
                dfs(j,visited,isConnected);
            }
        }
    }
}
