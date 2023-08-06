class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>>  triplets  = new ArrayList<>();
        for(int i=0;i<nums.length;i++){

        if(i>0 && nums[i]==nums[i-1]){
            continue;
        }

        int leftptr = i+1;
        int highptr =nums.length-1;
        while(leftptr < highptr)
        {
            if( nums[i] + nums[leftptr] + nums[highptr] < 0)
            {
            leftptr++;
            }
            else if (nums[i]+nums[leftptr]+nums[highptr] > 0)
            {

                highptr--;
            }

            else
            {
                triplets.add(Arrays.asList(nums[i],nums[leftptr],nums[highptr]));
                leftptr++;

                while(nums[leftptr] == nums[leftptr-1] && leftptr < highptr)
                leftptr++;
            }

            }
        
        }
        return triplets;
    }
}

