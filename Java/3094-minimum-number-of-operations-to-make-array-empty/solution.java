class Solution {
    public int minOperations(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums){

            map.put(num, map.getOrDefault(num,0)+1);
        }

        int result =0;

        for(int i :map.values()){
            if(i==1){
                return -1;
            }

            result = result + (i+2)/3;
        }
        return result;


        
    }
}
