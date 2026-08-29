class Solution {
    public List<String> letterCasePermutation(String s) {
       List<String> allper = new ArrayList<>();
       char[] nums = s.toCharArray();
       find(nums, allper, 0);
       return allper; 
    }

    public void find(char[] nums, List<String> allper, int start) {
       
        if(start == nums.length) {
            //base case
            allper.add(new String(nums));
            return;
        }

       
       char ch = nums[start];
       
        if(Character.isLetter(ch)) {
           
        nums[start] = Character.toLowerCase(ch);
        find(nums,allper,start+1);

        nums[start] = Character.toUpperCase(ch);
        find(nums,allper,start+1);
        }
        else{ // if it is a digit
            find(nums,allper,start+1);
        }
       


    }
}
