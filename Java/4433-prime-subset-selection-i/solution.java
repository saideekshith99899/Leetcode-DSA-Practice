class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        int sum =0;
        ArrayList<Integer> result = new ArrayList<>();
        for(int num = 2; num <= n; num++){
            boolean prime = true;
        for(int i=2; i*i<=num;i++){
            if(num % i == 0){
                prime = false;
                break;
            } 
        }
            if(prime) {
            
                if(sum + num > s) {
                    break;
                }
                sum = sum + num;
                result.add(num);
            }            
        }
        return result;
    }
}
