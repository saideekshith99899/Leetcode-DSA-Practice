class Solution {
    public int minGroups(int[][] intervals) {
       int groups = 0;
       Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
       PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       minHeap.add(intervals[0][1]);
       groups++;
       for(int i=1 ; i<intervals.length; i++) {
        int current = intervals[i][0];
        if(current > minHeap.peek()) {
           minHeap.poll();
           minHeap.add(intervals[i][1]);
        }
        else{
            groups++;
            minHeap.add(intervals[i][1]);
        }
        
       }
       return groups;
    }
}
