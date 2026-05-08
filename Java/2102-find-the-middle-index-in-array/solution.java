class Solution {
    public int findMiddleIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for(int i=1; i< nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        int leftsum, rightsum;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<prefix.length; i++) {
            leftsum = (i==0) ? 0 : prefix[i-1]; // i==0 leftside no elements
            rightsum = prefix[nums.length-1] - leftsum - nums[i]; 
            if(leftsum == rightsum) return i;
        }
        return -1;       
    }
}
