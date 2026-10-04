class Solution {
    public int minRotations(int n, String s) {
        int total = distance(0,s.charAt(0)-'0');
        for(int i=1; i<n; i++) {
            int a  = s.charAt(i-1) - '0';
            int b  = s.charAt(i)-'0';
            total = total + distance(a,b);
        }
        int result = total;
        for(int i=0; i<n;i++) {
            int cost;
            if(i ==0) {
                cost = total - distance(0,s.charAt(0)-'0') + distance(0,s.charAt(n-1)-'0');
                
            }
            else {
                int prev = s.charAt(i-1)-'0';
                int first = s.charAt(i)-'0';
                int end = s.charAt(n-1)-'0';
                cost = total - distance(prev,first) + distance(prev,end);
            }
            result = Math.min(result,cost);
        }
        return result;
    }

    public int distance(int a , int b) {
        int difference = Math.abs(a-b);
        return Math.min(difference, 10 - difference);
    }
}
