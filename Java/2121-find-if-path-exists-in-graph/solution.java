class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }
        return bfs(adj, source, destination);
    }
     public boolean bfs(List<List<Integer>> adj,
                       int source, int destination) {
        
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;
        while(queue.size() > 0) {
            int node = queue.poll();
            if(node == destination) return true;
            for(int nei : adj.get(node)) {
                if(!visited[nei]) {
                    queue.offer(nei);
                    visited[nei] = true;
                }
            }
        }
        return false;
    }
}
