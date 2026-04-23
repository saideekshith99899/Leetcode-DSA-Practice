class Solution {
    public int maximumSum(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int sum;
        int result = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {

            if(map.containsKey(digitSum(nums[i]))) {
                
                sum = nums[i] + map.get(digitSum(nums[i]));
                result = Math.max(result , sum);

                map.put(digitSum(nums[i]), Math.max(nums[i], map.get(digitSum(nums[i]))));

            }
            else{
            map.put(digitSum(nums[i]), nums[i]);       
            }
        }    
        return result == Integer.MIN_VALUE ? -1 : result;  
        
    }

    private int digitSum(int n){
        int sum = 0;
        int r;
        while(n > 0){
            r = n % 10;
            sum = sum + r;
            n = n/10;
        }

        return sum;
    }
}
