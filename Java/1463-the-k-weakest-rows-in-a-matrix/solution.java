class pair implements Comparable<pair> {
    int index;
    int freq;
    pair(int index, int freq) {
        this.index = index;
        this.freq = freq;
    }
    public int compareTo(pair t) {
        if(this.freq != t.freq) {
            return this.freq - t.freq;
        }
        return this.index - t.index;
    }
}
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<mat.length;i++) {
            int freq = 0;
            for(int j=0; j<mat[i].length;j++) {
                if(mat[i][j] == 1) {
                    freq++;
                }
            }
            pq.add(new pair(i,freq));  // index , freq
        }
        
        int[] result = new int[k];
        for(int i=0; i < k;i++) {
            pair top = pq.poll();
            result[i] =  top.index;
        }
        return result;
    }
}
