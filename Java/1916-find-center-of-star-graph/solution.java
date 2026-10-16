class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<edges.length; i++) {
            if(!map.containsKey(edges[i][0])) {
                map.put(edges[i][0] , new ArrayList<Integer>());
            }
            if(!map.containsKey(edges[i][1])) {
                map.put(edges[i][1], new ArrayList<>());
            }
        }
        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            map.get(u).add(v);
            map.get(v).add(u); // undirected;
        }
        int size = map.size()-1;
        for(int key : map.keySet()) {
            if(map.get(key).size() == size) {
                return key;
            }
        }
        return 0;
    }
}
