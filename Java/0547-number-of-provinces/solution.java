class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n]; // false
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                bfs(i,visited,isConnected);
                count++;
            }
        }
        return count;
    }

    public void bfs(int i, boolean[] visited, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;
        while(queue.size() > 0) {
            int node = queue.poll();
            for(int j=0; j < isConnected.length; j++ ) {
                if(isConnected[node][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    queue.offer(j);
                }
            }
        }
    }
}
