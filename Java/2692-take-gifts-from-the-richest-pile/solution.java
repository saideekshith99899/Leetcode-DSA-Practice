class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int gift: gifts){
            pq.add(gift);
        }
        for(int i=0; i<k;i++) {
        int top = pq.remove(); // 100 pop 
        int pile = (int)Math.sqrt(top);
        pq.add(pile);
        
        }
        //now add all 
       long sum = 0;
        for(int ele:gifts){
            sum = sum + pq.remove();
        }
        return sum;
    }
}
