class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxlen = 0;

        for(int i=0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int num: set) {
            if(!set.contains(num-1)) {  // num-1 =if it is not presnt then it is start        
                int count = 1;
                int current = num;
                while(set.contains(current + 1)) {
                    current++;
                    count++;
                }
               maxlen = Math.max(maxlen, count);
            }
        }
        return maxlen;       
    }
}
