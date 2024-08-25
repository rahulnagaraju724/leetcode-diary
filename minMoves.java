
class Solution {
    public int minMoves(int[] nums) {
        //453. Minimum Moves to Equal Array Elements
        // len*(min+k)=sum+k*(len-1).
        // ==> k=sum-min*len;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(int num: nums){
            min=Math.min(min,num);
            sum+=num;
        }
        return sum-(min*nums.length);
    }
}