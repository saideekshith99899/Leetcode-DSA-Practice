class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> result =new ArrayList();
        if(matrix.length ==0 || matrix[0].length==0){
            return result;
        }


        int rowbeg=0;
        int rowend =matrix.length-1;
        int colbeg=0;
        int colend=matrix[0].length-1;


        while(rowbeg <= rowend && colbeg <= colend){
            for(int i=colbeg;i<=colend;i++){
                result.add(matrix[rowbeg][i]);
            }
                rowbeg++;

              for(int i=rowbeg ;i<=rowend ;i++){
                  result.add(matrix[i][colend]);
              }  

              colend--;

              if(rowbeg <= rowend){
                  for(int i=colend;i>=colbeg;i--){
                      result.add(matrix[rowend][i]);
                  }
              }

              rowend--;


                if(colbeg <= colend){

                    for(int i=rowend;i>=rowbeg;i--){
                        result.add(matrix[i][colbeg]);
                    }
                }

                colbeg++;


        }



        return result;
    }
}  
    

