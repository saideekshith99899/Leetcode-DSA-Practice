class Solution {
    public int lastStoneWeight(int[] stones) {
        //max heap required
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele: stones){
            pq.add(ele);
        }

        while(pq.size() > 1){
            int first_highest = pq.remove();
            int second_highest = pq.remove();
            if(first_highest != second_highest) {
                pq.add(first_highest - second_highest);
            }
            else{
                pq.add(0);
            }
        }
        return pq.peek();
    }
}
