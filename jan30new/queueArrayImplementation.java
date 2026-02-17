public abstract class queueArrayImplementation {
    public static class Queue{
        int[] arr;
        int rear;
        int n;

        public Queue(int n){
            arr = new int[n];
            rear = -1;
            this.n = n;
        }

        // Enqueue O(1)
        public void add(int item){
            if(rear==n-1){
                System.out.print("Queue Full");
                return;
            }
            rear++;
            arr[rear] = item;
        }

        // Dequeue O(N)
        public int remove(){
            if(rear==-1){
                System.out.println("Empty queue");
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        // Peek O(1)
        public int peek(){
            if(rear==-1){
                System.out.print("Empty queue");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
}
