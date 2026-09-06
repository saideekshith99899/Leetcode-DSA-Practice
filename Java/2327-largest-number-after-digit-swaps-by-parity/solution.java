class Solution {
    public int largestInteger(int num) {
        int result = 0;
        PriorityQueue<Integer> even = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> odd = new PriorityQueue<>(Collections.reverseOrder());
        String s = String.valueOf(num);
        int[] nums = new int[s.length()]; 
        for(int i=0; i<s.length();i++){
            nums[i] = s.charAt(i) - '0';
            if(nums[i] % 2 == 0) {
                even.add(nums[i]);
            }
            else{
                odd.add(nums[i]);
            }
        }
// convert to number
        for(int x : nums) {
            if(x % 2 == 0) {
                result = result * 10 + even.remove();
            }
            else{
                result = result * 10 + odd.remove();
            }
        }
        return result;
    }
}
