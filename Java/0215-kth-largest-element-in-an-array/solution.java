class Solution {
    public int findKthLargest(int[] nums, int k) {
        //largest ele - take min heap
        //smallest ele - take max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add(num);
            if(pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
