class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        for(int i = 0; i< n-1; i++) {
            for(int j = 0; j<n-1-i; j++) {
                int count1 = Integer.bitCount(arr[j]);
                int count2 = Integer.bitCount(arr[j+1]);
                if(count1 > count2 || (count1 == count2 && arr[j] > arr[j+1])) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
