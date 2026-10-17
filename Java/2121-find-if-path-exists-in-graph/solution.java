class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
         boolean[] visited = new boolean[n]; 
         visited[source] = true;
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }
        return dfs(adj, source, destination,visited);
    }
     public boolean dfs(List<List<Integer>> adj,
                       int source, int destination, boolean[] visited) {     
           if(source == destination) return true;
            for(int nei : adj.get(source)) {
                if(!visited[nei]) {
                    if(nei == destination) return true;
                    visited[nei] = true;
                    if(dfs(adj,nei,destination,visited)){
                        return true;
                    }                 
                }
            }
        return false;
    }
}
