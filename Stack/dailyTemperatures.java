class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //739. Daily Temperatures
        Stack<Pair<Integer, Integer>> stack=new Stack<>();

        int n=temperatures.length;
        int answers[]=new int[n];

        for(int i=n-1;i>=0;i--){
            int temp=temperatures[i];
            if(stack.isEmpty()){
                stack.push(new Pair<>(temp,i));
                answers[i]=0;
            }else{
                while(!stack.isEmpty() && stack.peek().getKey()<=temp){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    answers[i]=0;
                }else{
                    int index=stack.peek().getValue();
                    answers[i]=index-i;
                }
                stack.push(new Pair<>(temp,i));
            }
        }

        return answers;
    }
}

//Love this, same way but saving only index


class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        int[] res = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; --i) {
            if (deque.isEmpty()) {
                deque.offerFirst(i);
                res[i] = 0;
            } else {
                while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peekFirst()]) {
                    deque.pollFirst();
                }

                if (deque.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = deque.peekFirst() - i;
                }

                deque.offerFirst(i);
            }
        }

        return res;
    }
}




class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = temperatures.length - 1; i >= 0; --i) {
            int currTemperature = temperatures[i];

            while (!stack.isEmpty() && currTemperature >= temperatures[stack.peekLast()]) {
                stack.pollLast();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peekLast() - i;
            }

            stack.offerLast(i);
        }

        return result;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--) {
		
			// Popping all indices with a lower or equal temperature than the current index
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                st.pop();
            }
			
			// If the stack still has elements, then the next warmer temperature exists!
            if(!st.isEmpty()) {
                ans[i] = st.peek() - i;
            }
			
			// Inserting current index in the stack: monotonicity is maintained!
            st.push(i);
        }
        
        return ans;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }

        return result;        
    }
}