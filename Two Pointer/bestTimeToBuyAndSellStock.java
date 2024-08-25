// Wrong approach, as highest value can be past and lowest can be future
class Solution {
    public int maxProfit(int[] prices) {
        //121. Best Time to Buy and Sell Stock
        int lowestPrice=Integer.MAX_VALUE;
        int highestPrice=Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowestPrice){
                lowestPrice=prices[i];
                highestPrice=Integer.MIN_VALUE; //work around line? -  doesnt work think [2,4,1] 2-4 is not calculated
            }
            if(prices[i]>highestPrice){
                highestPrice=prices[i];
            }
        }
        int sum=highestPrice-lowestPrice;
        if(sum>0){
            return sum;
        }
        return sum;
    }
}

// Brute force
class Solution {
    public int maxProfit(int[] prices) {
        //121. Best Time to Buy and Sell Stock
        
        int max = 0;
     
        for(int i=0; i<prices.length; i++){
               for(int j=i+1; j<prices.length; j++){
                   if(prices[j]>prices[i]){
                       int diff = prices[j]-prices[i];
                       if(diff>max)
                           max = diff;
                   }
               }
        }
        
        return max;
    }
}

// Optimised approach
class Solution {
    public int maxProfit(int[] prices) {
        //121. Best Time to Buy and Sell Stock        
        int min = Integer.MAX_VALUE;
        int profit =0;
        for(int i=0; i<prices.length; i++){
            if(prices[i]<min) min = prices[i];
            
            if(prices[i]-min>profit)
                profit = prices[i]-min;
             
        }
        
        return profit;
    }
}

// Latest code by me
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int low=prices[0];
        int high=prices[0];
        int maxProfit=0;
        for(int i=1;i<n;i++){
            if(prices[i]<low){
                low=prices[i];
                high=prices[i];
            }else if(prices[i]>high){
                high=prices[i];
                maxProfit=Math.max(maxProfit,high-low);   
            }
            // else{
            //     maxProfit=Math.max(maxProfit,prices[i]-low);
            // }
        }
        return maxProfit;
    }
}