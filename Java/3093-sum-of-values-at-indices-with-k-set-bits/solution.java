class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {

        int result =0;

        for(int i=0;i<nums.size();i++){
            int current = nums.get(i);

            if(bytesInNumber(i) == k){
                result =result + current;
            }
        }
            return result;
        }
 
    private static  int bytesInNumber(int num){

        int count = 0;
        String binary = Integer.toBinaryString(num);

        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i) == '1'){
                count++;
            }
        }

        return count;

    }
}
