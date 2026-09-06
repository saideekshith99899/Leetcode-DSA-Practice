class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele:piles){
            pq.add(ele);
        }
        for(int i=0; i<k;i++){
        int top = pq.remove();
        int x = top/2;
        pq.add(top-x);
        }
        
        int sum = 0;
        for(int ele: pq) {
            sum = sum + ele;
        }
        return sum;
        
    }
}
