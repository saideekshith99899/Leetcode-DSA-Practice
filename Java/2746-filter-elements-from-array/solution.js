/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
     
   newarr=[];
   for(let i=0;i<arr.length;i++){
       ele =arr[i];
       if(fn(ele,i)){
           newarr.push(ele);
       }
   }

   return newarr;
};
