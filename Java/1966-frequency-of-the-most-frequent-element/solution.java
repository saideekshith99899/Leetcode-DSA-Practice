class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int s=0,e=0,sum=0,len=0;
        while(e<nums.length){
            sum+=nums[e];
            while((e-s+1)*(nums[e])-sum>k) sum-=nums[s++];
            len=Math.max(len,e-s+1);
            e++;
        }
        return len;
    }
}
