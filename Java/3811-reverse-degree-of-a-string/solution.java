class Solution {
    public int reverseDegree(String s) {
        int[] arr = new int[26];
        for(int i = 0; i<26; i++) {
            arr[i] = 26-i;
        }
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
        char ch = s.charAt(i);
        int val = arr[ch - 'a'];
        sum = sum + (val *(i+1));        
        }
        return sum;
    }
}
