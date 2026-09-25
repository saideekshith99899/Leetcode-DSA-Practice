class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0] == b[0]) {
                return b[1]-a[1]; // if start equal sort large end at top first
            }
            else{
                return a[0]-b[0]; // sort start 
            }
        });

        int count = 1;
        int prevEnd = intervals[0][1];
        for(int i = 1; i< intervals.length; i++) {

            if(intervals[i][1] > prevEnd) {
                count++;
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
