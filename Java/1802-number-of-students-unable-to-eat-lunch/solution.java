class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
      Queue<Integer> queue = new LinkedList<>();

      for(int i=0; i<students.length; i++) {
        queue.offer(students[i]);
      }

      int i=0; 
      int count = 0;

      while(!queue.isEmpty()) {
        if( queue.peek() == sandwiches[i]) {
            queue.poll();
            count = 0;
            i++;
        }
        else{
            queue.offer(queue.poll());
            count++;
        }

        if(count == queue.size()) break; 
      }
      return queue.size();
    }
}
