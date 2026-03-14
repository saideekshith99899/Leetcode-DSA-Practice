class Solution {
    public int[] sortedSquares(int[] nums) {

    int n = nums.length;
    int left = 0;
    int right = n - 1;
    int k = n - 1;

    int[] result = new int[n];

    while(left <= right) {
        int leftnum = nums[left] * nums[left];
        int rightnum = nums[right] * nums[right];

        if(leftnum > rightnum){
            result[k] = leftnum;
            left++;
        }
        else{
            result[k] = rightnum;
            right--;
        }

        k--;
    } 
    return result;
    }
}
