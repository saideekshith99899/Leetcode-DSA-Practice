class pair implements Comparable<pair> {
    int sum;
    pair(int sum) {
        this.sum = sum;
    }
    public int compareTo(pair t) {
        return this.sum - t.sum;
    }
}
class Solution { 
    public int kthSmallest(int[][] mat, int k) {
     int m = mat.length;
     int n = mat[0].length;
     PriorityQueue<pair> pq = new PriorityQueue<>(Collections.reverseOrder());
     for(int col = 0; col < n; col++){
        pq.add(new pair(mat[0][col]));

        if(pq.size() > k) pq.poll();
     }

     //add rem rows
     for(int row = 1; row < m; row++) {
        PriorityQueue<pair> next = new PriorityQueue<>(Collections.reverseOrder());
        for(pair p:pq) {
            for(int col = 0; col < n; col++) {
                int newsum = p.sum + mat[row][col];
                next.add(new pair(newsum));
                if(next.size() > k) next.remove();
            }
        }
        pq = next;
    }
     return pq.peek().sum;
    }
}
