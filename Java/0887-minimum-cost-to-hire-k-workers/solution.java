class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n= quality.length;
        Double result = Double.MAX_VALUE;
        double[][] workers = new double[n][2];

        for(int i=0; i<n;i++) {
            workers[i][0] = (double) wage[i] / quality[i];
            workers[i][1] = quality[i];
        }

        Arrays.sort(workers, (a,b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int sumQuality = 0;
        for(int i =0; i< n; i++) {
            double ratio = workers[i][0];
            double qual = workers[i][1];

            sumQuality += qual;
            maxHeap.add(qual);

            if(maxHeap.size() > k) {
                sumQuality -= maxHeap.poll();
            }
            if(maxHeap.size() == k) {
                double cost = sumQuality * ratio;
                result = Math.min(result, cost);
            }
        }
        return result;
    }
}
