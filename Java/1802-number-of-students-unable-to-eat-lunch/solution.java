class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<students.length; i++) {
            queue.offer(students[i]);
        }
        
  int i = 0; //track sandwhich
  int count = 0;
        while(!queue.isEmpty()) {
            if( queue.peek() == sandwiches[i]){
               queue.poll();
               i++;
               count = 0;
            }
            else{ // not equal -> add in queue
            queue.offer(queue.poll());
            count++;
            }

            if(count == queue.size()) break;
        }
        return queue.size();
    }
}
