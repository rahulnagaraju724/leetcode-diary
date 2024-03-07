class Solution {
    int minMoves=Integer.MAX_VALUE;
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        //System.out.println("n="+n);
        // int n=7;
        // for (int i = 1; i < n * n; i++) {
        //     int[] indexes = findRowCol(i, n);
        //     System.out.println("Number: " + i + " and row, col =[" + indexes[0] + "," + indexes[1] + "]");
        // }
        for (int i = 1; i <= 6; i++) {
            // int[] indexes = findRowCol(i,n);
            // snakesAndLadders(board,n,indexes[0],indexes[1],1,i);
            //System.out.println("Die first timne");
            if(i > n*n){
                return minMoves;
            }
            int[] indexes = findRowCol(i,n);
            int value=board[indexes[0]][indexes[1]];
            if(value==-1){
               snakesAndLadders(board,n,indexes[0],indexes[1],1,i);
            }else{
                indexes = findRowCol(value,n);
                snakesAndLadders(board,n,indexes[0],indexes[1],1,value);
            }

        }
        return minMoves==Integer.MAX_VALUE?-1:minMoves;
    }

    public void snakesAndLadders(int[][] board,int n, int row, int col, int moves, int number) {
        if (number==n*n) {
            // System.out.println("Inside row and col:"+ moves);
            // System.out.println();
            minMoves=Math.min(minMoves,moves);
            return;
        }
        if(row<0 || row >=n || col<0 || col>=n ){
            return;
        }


        //System.out.println(" Currently at number: "+number+" and Index of row:"+row+" ,col:"+col+" and Moves:"+moves);
        if(moves>=minMoves || moves>n*n){
            return;
        }


        for (int i = 1; i <= 6; i++) {
            if(number+i > n*n){
                return;
            }
            int[] indexes = findRowCol(number+i,n);
            int value=board[indexes[0]][indexes[1]];
            if(value==-1){
                snakesAndLadders(board,n,indexes[0],indexes[1],moves+1,number+i);
            }else{
                indexes = findRowCol(value,n);
                snakesAndLadders(board,n,indexes[0],indexes[1],moves+1,value);
            }
           
        }
        return;
    }

    public int[] findRowCol(int number, int n){
        int row = n - (number/n) - 1; // Bcz number starts from below
        int col = number % n;
        if(col==0){
            row=row+1;
            if((number/n)%2==1){
                col=n-1;
            }
            else{
                col=0;
            }
            return new int[]{row,col};
        }
        if(n%2==0){ // Ex 6 6 matrix
            if(row%2==1){
                col=col-1;

            }else{
                col=n-col;
            }
        }else{ // for 7 7 matrix
            if(row%2==1){
                col=n-col;

            }else{
                col=col-1;
            }
        }
        return new int[]{row, col};
    }
}