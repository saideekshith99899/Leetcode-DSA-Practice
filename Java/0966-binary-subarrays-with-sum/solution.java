class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0;
        int sum=0;

        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int num:nums){
            sum=sum+num;
            if(sum == goal){
                count++;
            }

            count+=hash.getOrDefault(sum-goal,0);
            hash.put(sum,hash.getOrDefault(sum,0)+1);
        }

        return count;
        
    }
}
