class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue=new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        Queue<Integer> tempQueue=new LinkedList<Integer>();
        int size=queue.size();
        while(!queue.isEmpty() && size>1){
            tempQueue.offer(queue.poll());
            size--;
        }
        int element = queue.poll();

        while(! tempQueue.isEmpty()){
            queue.offer(tempQueue.poll());
        }
        return element;
    }
    
    public int top() {
        Queue<Integer> tempQueue=new LinkedList<Integer>();
        int size=queue.size();
        while(!queue.isEmpty() && size>1){
            tempQueue.offer(queue.poll());
            size--;
        }
        int element = queue.peek();
        tempQueue.offer(queue.poll());
        while(! tempQueue.isEmpty()){
            queue.offer(tempQueue.poll());
        }
        return element;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */



 class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */