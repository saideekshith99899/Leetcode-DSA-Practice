class Solution {
    public int fib(int n) {

        if(n==1 || n==2){
            return 1;
        }
        else if(n==0){
            return 0;
        }
        else
        {
            int a=1;
            int b=1;
            int c;

            for(int i=3; i<=n; i++){
                c=a+b;
                a=b;
                b=c;
            }
            return b;
        }
    }
}

