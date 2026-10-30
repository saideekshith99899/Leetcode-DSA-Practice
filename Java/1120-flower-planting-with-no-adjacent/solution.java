class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
       List<Integer>[] adj = new ArrayList[n+1];
       for(int i=1; i<=n; i++) {
        adj[i] = new ArrayList<>();
       }  
       for(int[] path : paths) {
        int u = path[0];
        int v = path[1];
        adj[u].add(v);
        adj[v].add(u); // bidirectional;
       }

       int[] result = new int[n];
       for(int i=1; i<=n; i++){
            if(result[i-1] == 0){
                dfs(adj,result,i);
            }
       }
        return result;
    }
    public void dfs(List<Integer>[] adj, int[] result, int curr) {
        boolean[] used = new boolean[5];
        for(int nei : adj[curr]) {
            if(result[nei-1] != 0) {
                used[result[nei-1]] = true;
            }
        }

        for(int color =1; color <=4; color++) {
            if(!used[color]) {
                result[curr-1] = color;
                break;
            }
        }

        for (int nei : adj[curr]) {
            if (result[nei - 1] == 0) {
                dfs(adj, result, nei);
            }
        }
    }
}
