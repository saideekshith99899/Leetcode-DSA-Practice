class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int minlen = Integer.MAX_VALUE;
        long[] prefix = new long[nums.length + 1];
        prefix[0] = 0;
        Deque<Integer> deque = new LinkedList<>();
        // to find the exact i location we need deque 
        for(int i = 1; i<= nums.length; i++) {
            prefix[i] = prefix[i-1]+ nums[i-1];
        }

        for(int j =0; j< prefix.length ; j++) {
            while(!deque.isEmpty() && 
                    prefix[j] - prefix[deque.peekFirst()] >= k) {

                    minlen = Math.min(minlen , j - deque.peekFirst());
                    deque.pollFirst();
            }

            while(!deque.isEmpty() &&
                    prefix[deque.peekLast()] >= prefix[j]) {
                        deque.pollLast();
            }

            deque.offerLast(j); // always index
        }

    return minlen == Integer.MAX_VALUE ? -1 : minlen;
        
    }
}
