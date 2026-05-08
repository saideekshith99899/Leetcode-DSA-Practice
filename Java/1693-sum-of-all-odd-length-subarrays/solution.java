class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        int sum = 0;
        for(int len = 1; len <= arr.length ; len=len+2) {
            
            for(int i=0; i<=arr.length - len; i++) {
                int end = i+len -1;
                int rangesum = (i==0) ? prefix[end]:prefix[end] - prefix[i-1];
                sum = sum + rangesum;
            }
        }
        return sum;
    }
}
