class Solution {
    public int getWinner(int[] arr, int k) {
            int n = arr.length;

            int winner = arr[0];
            int count=0;

        for(int i=1;i<n;i++){
        
        if(arr[i] > winner){

            winner = arr[i];
            count=1;
        }

        else
        {
            count++;
        }

        if(count ==k){
            return winner;
        }
        
        




        }


        return winner;

        
    }
}
