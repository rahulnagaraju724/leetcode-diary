class Solution {
    public int coinChange(int[] coins, int amount) {
        //322. Coin Change
        // Greedy approach
        if(amount==0){
            return 0;
        }
        Arrays.sort(coins);
        int i=coins.length-1;
        int sum=0;
        while(amount>0 && i>=0){
            if(amount/coins[i]>=1){
                sum+=amount/coins[i];
                amount=amount%coins[i];
                
            }
            i=i-1;
        }
        return sum==0 || amount!=0 ? -1:sum;
    }
}