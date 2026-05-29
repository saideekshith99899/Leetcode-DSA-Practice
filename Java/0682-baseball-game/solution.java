class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0 ;i <operations.length; i++){
        if(operations[i].equals("C")) {
            stack.pop();
        }
        else if(operations[i].equals("D")){
            int x = stack.peek() * 2;
            stack.push(x);
        }

        else if(operations[i].equals("+")){
            int a = stack.peek();
            stack.pop();
            int b = stack.peek();
            int x1 = a+b;
            stack.push(a);
            stack.push(x1);
        }
        else{
          stack.push(Integer.parseInt(operations[i]));
        }
    }
    int sum = 0;
    for(int val: stack){
        sum = sum + val;
    }
    return sum;
    }
}
