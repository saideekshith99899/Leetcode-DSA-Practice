class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0; i<n; i++) {
            if(color[i] == -1){
                if(!bfs(graph,color,i)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean bfs(int[][] graph, int[] color, int i){
        Queue<Integer> queue = new LinkedList<>();
        color[i] = 0; // 0 - red, 1 - blue
        queue.add(i);
        while(queue.size() > 0){
            int curr = queue.poll();
            for(int nei : graph[curr]){
                if(color[nei] == -1) {
                    color[nei] = 1-color[curr]; // give opp color 0->1
                    queue.offer(nei);
                }
                else if(color[nei] == color[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}
