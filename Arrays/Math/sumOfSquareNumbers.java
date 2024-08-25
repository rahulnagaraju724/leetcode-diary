class Solution {
    public boolean judgeSquareSum(int c) {
        //633. Sum of Square Numbers
        if(c==0 || c==1){
            return true;
        }
        int d=(int)Math.sqrt(c);
        for(int a=1;a<=d;a++){
            int remaining=c-(a*a);
            if(perfectSquare(remaining)){
                return true;
            }
        }
        return false;
    }

    public boolean perfectSquare(int input){
        int sqrt=(int) Math.sqrt(input);
        return Math.pow(sqrt,2)==input;
    }
}