class Triplet implements Comparable<Triplet>{
    float fraction;
    int val1;
    int val2;
    Triplet(float fraction ,int val1,int val2){
        this.fraction = fraction;
        this.val1 = val1;
        this.val2 = val2;
    }

    public int compareTo(Triplet t){
       return Float.compare(this.fraction, t.fraction);
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                if(i < j) {
                    float fraction =(float) arr[i] / arr[j];
                    pq.add(new Triplet(fraction, arr[i],arr[j]));
                    if(pq.size() > k) pq.poll();
                }
            }
        }

        Triplet ans = pq.peek();
        return new int[]{ans.val1, ans.val2};
    }
}
