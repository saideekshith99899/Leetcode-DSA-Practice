class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int dislike[] : dislikes){
            int u = dislike[0];
            int v = dislike[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] color = new int[n+1];
        Arrays.fill(color,-1);

        for(int i=1; i<=n; i++) {
            if(color[i] == -1) {
                color[i]=0;
                if(!dfs(adj,color,i)){
                    return false;
                }
            }
        }
    return true;
    }
    public boolean dfs(List<Integer>[] adj, int[] color , int curr){
        for(int nei: adj[curr]){
            if(color[nei] == -1){
                color[nei] = 1 - color[curr];
                if(!dfs(adj,color,nei)) {
                    return false;
                }
            }
            else if(color[nei] == color[curr]){
                return false;
            }
        }
        return true;
    }
}
