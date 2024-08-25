class Solution {
    public int equalPairs(int[][] grid) {
        //2352. Equal Row and Column Pairs
        int finalCount=0;
        int n=grid.length;
        for(int row=0;row<n;row++){
            
            for(int col=0;col<n;col++){
                int rowCol=0;
                int colRow=0;
                int count=0;
                while(rowCol<n && colRow<n && grid[row][rowCol]==grid[colRow][col]){
                    count++;
                    rowCol++;
                    colRow++;
                }
                //System.out.println("Row: "+row+" Col:"+col+" Count:"+count);
                if(count==n){
                    finalCount++;
                }
            }
        }
        return finalCount;
    }
}