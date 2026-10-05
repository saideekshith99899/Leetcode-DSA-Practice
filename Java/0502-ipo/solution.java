class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        int[][] capital_profit = new int[n][2];
        for(int i=0; i<n;i++) {
            capital_profit[i][0] = capital[i];
            capital_profit[i][1] = profits[i];
        }
        Arrays.sort(capital_profit ,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while(k > 0) {
            while(i < n && capital_profit[i][0] <= w) {
                maxHeap.add(capital_profit[i][1]);
                i++;
            } 
            if(maxHeap.isEmpty()) break;
            w = w + maxHeap.poll();
            k--;
        }
        return w;
    }
}
