class Solution {
    public String findDifferentBinaryString(String[] nums) {

        Set<String> result = new HashSet<>();

        for(String num:nums){
            result.add(num);
        }
             int n = nums[0].length();
        for(int i=0;i<Math.pow(2,n);i++){

            String cn = Integer.toBinaryString(i);

            while(cn.length()<n){
                cn="0"+cn;
            }
            if(!(result.contains(cn)))
            {
            return cn;
            }
        }
        

        return "";
    
}
}
