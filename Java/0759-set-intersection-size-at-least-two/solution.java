class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> {
            if(a[1] == b[1]) return b[0]-a[0];
            else return a[1]-b[1];
        });

        int secondLast = -1;
        int last = -1;
        int count = 0;
        for(int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(secondLast >= start) {
                continue;
            }

            if(last >= start) {
                secondLast = last;
                last = end;
                count++;
            }

            else{
                secondLast = end-1;
                last = end;
                count = count + 2;
            }
        }
        return count;
    }
}
