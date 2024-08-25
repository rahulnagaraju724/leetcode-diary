class MinStack {

    Stack<Integer> stack;

    Stack<Integer> minStack;

    public MinStack() {
        //155. Min Stack
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);

        // if(minStack.isEmpty()){
        //     minStack.push(val);
        // }
        // else{
        //     int minValue=minStack.peek();
        //     if(minValue>val){
        //         minStack.push(val);
        //     }else{
        //         minStack.push(minValue);  
        //     }
        // }

        // Instead of all above if and else
        // The min stack may be empty, so we need to check it
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

// Just WOOOOW - no words
class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}


// See down
class MinStack {
    LinkedList<TplusMin> stack;
    private class TplusMin {
        int val;
        int min;
        public TplusMin(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack() {
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        int newMin;
        if (stack.size() == 0){
            newMin = val;
        }
        else {
            int currentMin = stack.getFirst().min;
            newMin = val < currentMin ? val : currentMin;
        }
        stack.addFirst(new TplusMin(val, newMin));
    }
    
    public void pop() {
        stack.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst().val;
    }
    
    public int getMin() {
        return stack.peekFirst().min;
    }
}


// May be the correct way of doing?
class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair<>(val, val));
        } else {
            int min = Math.min(stack.peek().getValue(), val);
            stack.push(new Pair<>(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getKey();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getValue();
    }
}