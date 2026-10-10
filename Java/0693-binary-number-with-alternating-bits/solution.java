class Solution {
    public boolean hasAlternatingBits(int n) {
    String binary = Integer.toBinaryString(n);
    int[] nums = new int[binary.length()];
    for(int i=0; i< binary.length(); i++) {
        nums[i] = binary.charAt(i)- '0';
    }

    for(int i=1; i<nums.length; i++) {
        if(nums[i]  == nums[i-1]) return false;
    }
    return true;
    }
}
