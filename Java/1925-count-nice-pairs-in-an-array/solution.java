class Solution {
    public int countNicePairs(int[] nums) {
        
        long count =0;
        int mod = 1000000007;

        HashMap<Integer,Integer> map =new HashMap<>();

        for(int num :nums){
            int diff = num - reverse(num);
            map.put(diff,map.getOrDefault(diff,0)+1);
        }

        for(int freq: map.values()){

             count = (int)((count + (long) freq * (freq - 1) / 2) % mod);


        }

        return (int) count;
        
    }

    public static int reverse(int num){

        int rev = 0;
        int rem;

        while(num>0){
           rem= num%10;
            rev = rev * 10 + rem;
            num = num/10;
        }

         return rev;
    }

    public long fact(int n){
        if(n==1)
            return 1;
        return n+fact(n-1);
    }
   


}
