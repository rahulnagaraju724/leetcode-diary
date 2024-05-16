class Solution {
    public int matrixScore(int[][] grid) {
        //861. Score After Flipping Matrix
        // Timer - 50 mins
        int m=grid.length;
        int n=grid[0].length;

        int[] leadingOnes=new int[m];
        int[] moreThanHalfOnes=new int[n];

        // for rows
        for(int i=0;i<m;i++){
            // StringBuilder str=new StringBuilder();
            if(leadingOnes[i]==1 || grid[i][0]==1){
                leadingOnes[i]=1;
                continue; // Dont go through that row
            }
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    grid[i][j]=1;
                }    else{
                    grid[i][j]=0;
                }                     
            }
            i=i-1; // Bcz if not leading zero, go again              
        }

        // for cols
        for(int j=0;j<n;j++){
            int count=0;
            for(int i=0;i<m;i++){
                if(grid[i][j]==0){
                    count++;
                }
            }
            if(count>m/2){
                //changeCol();
                for(int i=0;i<m;i++){
                    if(grid[i][j]==0){
                        grid[i][j]=1;
                    }else{
                        grid[i][j]=0;
                    }
                }
                moreThanHalfOnes[j]=1;
            }
        }


        //count now
        int sum=0;
        for(int i=0;i<m;i++){
            StringBuilder binaryString=new StringBuilder();
            for(int j=0;j<n;j++){
                binaryString.append(grid[i][j]);
            }
            int decimal=Integer.parseInt(binaryString.toString(),2);  
            sum+=decimal;
        }
        return sum;
    }

}