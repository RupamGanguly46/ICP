import java.util.Queue;

public class circularQueueArrayImplementation {
    static class cirQueue{
        int[] arr;
        int n;
        int front;
        int rear;

        public cirQueue(int n){
            arr = new int[n];
            front = -1;
            rear = -1;
            this.n = n;
        }

        public boolean isFull(){
            return (rear + 1) % n == front;
        }

        public boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        // Enqueue
        public void add(int item){
            if(isFull()){
                System.out.println("Queue is full!");
                return;
            }
            if(isEmpty()){
                front = 0;
            }
            rear = (rear + 1) % n;
            arr[rear] = item; 
        }

        // Dequeue
        public int remove(){
            if(isEmpty()){
                System.out.print("Queue is empty!");
                return -1;
            }

            int ans = arr[front];

            // arr[front] = 0; No need, whatever element remaining here, it will be updateable.

            // If only one element present
            if(front == rear){
                front = rear = -1;
            }

            else{
                front = (front+1) % n;
            }

            return ans;
        }

        // Peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Empty queue!");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        cirQueue q = new cirQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.peek());
        System.out.println(q.arr[0]);
    }
}
