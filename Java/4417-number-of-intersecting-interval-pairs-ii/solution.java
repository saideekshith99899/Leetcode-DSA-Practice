class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int[] startPoints = new int[intervals.length];
        int[] endPoints = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            startPoints[i] = intervals[i][0];
            endPoints[i] = intervals[i][1];
        }
        Arrays.sort(startPoints);
        Arrays.sort(endPoints);

        long nonIntersectPairs = 0;
        int j = 0;
        for(int i=0; i< intervals.length; i++) {
            while(j < intervals.length && endPoints[j] < startPoints[i]){
                j++;
            }
            nonIntersectPairs += j;
        }
        int n = intervals.length;
        long totalPairs = (long) n*(n-1)/2;
        return totalPairs - nonIntersectPairs;
    }
}
