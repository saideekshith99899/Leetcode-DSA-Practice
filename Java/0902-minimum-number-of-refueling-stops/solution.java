class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(startFuel >= target) return 0;
        int i=0, stops = 0, n = stations.length, maxDist = startFuel;
        while(maxDist < target) {
            while (i < n && stations[i][0] <=  maxDist) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            if(maxHeap.isEmpty()) return -1;
            maxDist = maxDist + maxHeap.poll();
            stops++;
        }
        return stops;
    }
}
