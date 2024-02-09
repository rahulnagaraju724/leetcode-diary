class Solution {
    public int evalRPN(String[] tokens) {
        //150. Evaluate Reverse Polish Notation
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            //try{
            if(!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*") )){
                int num=Integer.parseInt(tokens[i]);
                stack.push(num);
            //}catch(Exception e){
            }else{
                int a=stack.pop();
                int b=stack.pop();
                if(tokens[i].equals("+")){
                    stack.push(a+b);
                }else if(tokens[i].equals("-")){
                    stack.push(b-a);
                }else if(tokens[i].equals("*")){
                    stack.push(a*b);
                }else{
                    stack.push(a == 0 ? a : b / a);
                }
            }
        }
        return stack.pop();
    }
}