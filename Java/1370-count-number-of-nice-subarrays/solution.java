class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int odd =0;
        int left =0;
        int right=0;
        int temp =0;

        while(right < nums.length){
            if(nums[right] % 2 ==1){
                odd++;
                temp=0;
            }

            while(odd == k){
                temp++;
                if(nums[left] % 2==1){
                    odd--;
                }

                left++;
            }

            count=count+temp;
            right++;
        }

        return count;




    }
}
