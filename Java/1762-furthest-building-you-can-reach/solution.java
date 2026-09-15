class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // min heap 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<heights.length - 1; i++) {
            int diff = heights[i+1] - heights[i];
            if(diff < 0) continue; //true-no need any, jump possible-inc i++
            pq.add(diff);
            if(pq.size() > ladders) {  // indirect ladders-- happen 
                bricks = bricks - pq.poll();
            }
            if(bricks < 0) return i;
        }
        return heights.length-1;
    }
}
