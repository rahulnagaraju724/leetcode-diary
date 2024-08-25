class Solution {
    Integer Max_Score=Integer.MIN_VALUE;
    public int bagOfTokensScore(int[] tokens, int power) {
        //948. Bag of Tokens
        bagOfTokensScore(tokens,power,0,0);
        return Max_Score;
    }
    public void bagOfTokensScore(int[] tokens, int power, int score,int index){
        if(index>=tokens.length){
            return;
        }
        if(tokens[index]<=power){
            power=power-tokens[index];
            score=score+1;
        }else{
            if(score>0){
                power=power+tokens[index];
                score=score-1;
            }
        }
        Max_Score=Math.max(score,Max_Score);
        bagOfTokensScore(tokens,power,score,index+1);
        return;
   }
}