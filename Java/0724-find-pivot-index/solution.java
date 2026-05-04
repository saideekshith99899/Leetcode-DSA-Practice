class Solution {
    public int pivotIndex(int[] nums) {
        int leftsum , rightsum;
        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];
        for(int i = 1; i< nums.length ; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }

        for(int i=0 ;i< prefix.length ; i++) {
            leftsum = (i == 0)  ? 0 : prefix[i-1];
            rightsum =  prefix[prefix.length - 1] - prefix[i];
            if(leftsum == rightsum) return i;
        }
        return -1;
    }
}
