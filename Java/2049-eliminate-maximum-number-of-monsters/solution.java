class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] t = new double[n];
        for(int i=0;i<n;i++){

            double time = dist[i]* 1.0/speed[i];
            t[i] =time;
        }

       Arrays.sort(t);
        int count=0;
        int time=0;
        for(double temp : t){
            if(temp>time){
                count++;
            }
            else
            {
                break;
            }
            time++;
        }
        
        return count;
    }
}
