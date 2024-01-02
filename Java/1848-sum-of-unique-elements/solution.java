public class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
               
                    break;
                }
                
    
                if (j == nums.length - 1) {
                    arr[i] = nums[i];
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
        }

        return sum;
    }
}

