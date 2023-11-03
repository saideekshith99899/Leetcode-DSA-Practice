class Solution {
    public List<String> buildArray(int[] target, int n) {

        List<String> op = new ArrayList<>();

        int j=0;
        for(int i=1;i<=n;i++){
            if(j >= target.length)
            break;

            if(target[j] == i){
            op.add("Push");
            j++;
        }

        else{
            op.add("Push");
            op.add("Pop");
        }
        }

        return op;


        
    }
}
