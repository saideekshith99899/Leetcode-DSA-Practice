class Solution {
    public int halveArray(int[] nums) {
        //max heap
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int num: nums) {
            pq.add((double)num);
            sum = sum + num;
        }
        double target = sum / 2;
        double reduce = 0;
        int minOperations = 0;
        while(reduce < target) {
            double top = pq.poll();
            double half = top /2;
            reduce = reduce + half;
            pq.add(half);
            minOperations++;
        }
        return minOperations;
    }
}
