class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxdeque = new LinkedList<>();
        Deque<Integer> mindeque = new LinkedList<>();

// monotonic maxdeque= [max ..... min] = decreasing order
// monotonic mindeque = [min.......max] = increasing order
    int left = 0; 
    int ans = 0;

        for(int right=0; right <nums.length; right++) {
            while(!maxdeque.isEmpty() && 
                        nums[maxdeque.peekLast()] < nums[right]){
                
                maxdeque.pollLast();
            }
            maxdeque.offerLast(right);

            while(!mindeque.isEmpty() &&
                        nums[mindeque.peekLast()] > nums[right]){
           
                 mindeque.pollLast(); 
            }
            mindeque.offerLast(right);

// here sliding window - dynamic (right - left + 1) for max subarry length
while(nums[maxdeque.peekFirst()] - nums[mindeque.peekFirst()] > limit) {

    left++;
    if(maxdeque.peekFirst() < left) maxdeque.pollFirst();
    if(mindeque.peekFirst() < left) mindeque.pollFirst();
}

ans = Math.max(ans, right - left + 1);
        }

return ans;

    }
}
