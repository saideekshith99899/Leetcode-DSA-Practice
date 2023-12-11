class Solution {
    public int findSpecialInteger(int[] arr) {

        int n = arr.length/4;

        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            int num =arr[i];

            hash.put(num,hash.getOrDefault(num,0)+1);

        }

        for(Map.Entry<Integer,Integer> e :hash.entrySet())
        {
            if(e.getValue() > n){
                return e.getKey();
            }
        }



        return 0;
        
    }
}
