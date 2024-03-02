public class Solution {
    class Queue {
        int front, rear;
        int []arr;

        Queue() {
            front = 0;
            rear = 0;
            arr = new int[100001];
        }

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            // Write your code here.

            arr[rear]= e;
            rear++;

        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            // Write your code here.

            //if(rear==front && arr[rear]==0){
            if(rear==front){
                return -1;
            }

            // int temp=arr[front];
            // arr[front]=0;
            // front++;
            // return temp;
            return arr[front++];
        }
    }
}
