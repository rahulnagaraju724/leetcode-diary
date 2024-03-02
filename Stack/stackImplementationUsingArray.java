// import java.util.List;
// import java.util.ArrayList;

// public class Solution{
//     static class Stack {

//         private List<Integer> stack;
//         private int capacity;
//         Stack(int capacity) {
//             // Write your code here.
//             this.stack=new ArrayList<Integer>();
//             this.capacity=capacity;
//         }
//         public void push(int num) {
//             // Write your code here.
//             if(isFull()==1){
//                 return;
//             }
//             stack.add(num);
//         }
//         public int pop() {
//             // Write your code here.
//             if(isEmpty()==1){
//                 return -1;
//             }
//             return stack.remove(stack.size()-1);
//         }
//         public int top() {
//             // Write your code here.
//             if(isEmpty()==1){
//                 return -1;
//             }
//             return stack.get(stack.size()-1);
//         }
//         public int isEmpty() {
//             // Write your code here.
//             return 0==stack.size()? 1:0;
//         }
//         public int isFull() {
//             // Write your code here.
//             return capacity==stack.size()? 1:0;
//         }
//     }
// }


import java.util.List;
import java.util.ArrayList;

public class Solution{
    static class Stack {

        private int[] stack;
        //private int capacity;
        private int index;
        Stack(int capacity) {
            // Write your code here.
            this.stack=new int[capacity];
            //this.capacity=capacity;
            this.index=-1;
        }
        public void push(int num) {
            // Write your code here.
            if(isFull()==1){
                return;
            }
            stack[++index]=num;
        }
        public int pop() {
            // Write your code here.
            if(isEmpty()==1){
                return -1;
            }
            return stack[index--];
        }
        public int top() {
            // Write your code here.
            if(isEmpty()==1){
                return -1;
            }
            return stack[index];
        }
        public int isEmpty() {
            // Write your code here.
            return 0==index+1? 1:0; // or index==-1
        }
        public int isFull() {
            // Write your code here.
            //return capacity==index+1? 1:0; // or index==stack.length()-1
            return index==stack.length-1? 1:0;
        }
    }
}