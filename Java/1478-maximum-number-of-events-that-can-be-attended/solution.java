class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0]-b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        int i=0;
        int count = 0;
        int day = 0;
        int n = events.length;
        while(i < n  || !minHeap.isEmpty()) {
            if(minHeap.isEmpty()) {
                // day - 0 
                day = events[i][0];
            }
            while( i < n && events[i][0] <= day) {
                minHeap.add(events[i][1]);
                i++;
            }

            minHeap.poll();
            count++;
            day++;
            while(!minHeap.isEmpty() && minHeap.peek() < day) {
            minHeap.poll();
            }
        }
        return count;
    }
}
