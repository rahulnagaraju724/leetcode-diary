class Solution {
    public int numSquares(int n) {
        //279. Perfect Squares

        if(n==1){
            return 1;
        }
        List<Integer> perfectSquares=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(i*i<=n){
                perfectSquares.add(i*i);
            }
            else{
                break;
            }
        }
        // for(int i:perfectSquares){
        //     System.out.println("i :"+i);
        // }
        int[] leastNumber = {Integer.MAX_VALUE};
        findLeastNumber(n,perfectSquares,leastNumber,0,0,perfectSquares.size()-1);
        return leastNumber[0];
    }

    public void findLeastNumber(int n,List<Integer> perfectSquares,int[] leastNumber,int count, int sum, int index){
        if(sum==n){
            //System.out.println("Inside here, leastNumber:"+leastNumber+" Count:"+count);
            leastNumber[0]=Math.min(leastNumber[0],count);
            //System.out.println("after updating, leastNumber:"+leastNumber+" Count:"+count);
            return;
        }
        if(sum>n){
            return;
        }
        if(index>=0){
            if(sum<n){
                //System.out.println("Picking "+ perfectSquares.get(index));
                sum=sum+perfectSquares.get(index);
                count++;
                //System.out.println(sum+" "+count);
                findLeastNumber(n,perfectSquares,leastNumber,count,sum,index);
                //System.out.println("UNPicking "+ perfectSquares.get(index));
                sum=sum-perfectSquares.get(index);
                count--;
                //System.out.println(sum+" "+count);
                findLeastNumber(n,perfectSquares,leastNumber,count,sum,index-1);
            }

        }
        //System.out.println(leastNumber);
        return;
    }

}


// Time complexity: O(N * sqrt(N))
// Space complexity: O(N)

class Solution{
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }
        
        return dp[n];
    }
    }
