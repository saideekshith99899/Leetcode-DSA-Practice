class Solution {
    public long maxAlternatingSum(int[] nums) {
        long sum1 = 0;
        long sum2 = 0;
        long sum = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            if(num < 0){
                num = Math.abs(num);
            }
            maxHeap.add(num);
        }
        for(int i=0; i<nums.length; i++) {
            
            int n = nums.length;

            while(!maxHeap.isEmpty()) {
            if(n % 2 == 0) {
                //even length
                for(int j = 0; j<n/2; j++) {
                    int a = maxHeap.poll();
                    sum1 = sum1 + a*a;
                }

                for(int k = n/2; k<n; k++) {
                    int b = maxHeap.poll();
                    sum2 = sum2 + b*b;
                }

                sum = sum1 - sum2;
            }

            else{
                // odd
                for(int j = 0; j<=n/2; j++) {
                    int a = maxHeap.poll();
                    sum1 = sum1 + a*a;
                }
                for(int k = n/2+1; k<n; k++) {
                    int b = maxHeap.poll();
                    sum2 = sum2 + b*b;
                }
                sum = sum1- sum2;

            }
        }
        }
        return sum;
    }
}
