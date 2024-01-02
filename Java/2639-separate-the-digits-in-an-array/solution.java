class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums){

            List<Integer> temp = new ArrayList<>();

            int curr = num;
            while(curr > 0){

                int digit = curr % 10;
             

                temp.add(digit);
                curr = curr/10;
            }

            for(int j=temp.size()-1;j>=0;j--){

                list.add(temp.get(j));
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }


        return result;

      
    }
}
