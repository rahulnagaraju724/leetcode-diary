// class Solution {
//     public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//         //576. Out of Boundary Paths    
        
//         if(maxMove<0){
//             return 0;
//         }
//         // Not valid cz some boundaries have 3 or 4 ways
//         // if((startRow==0 && startColumn==0) || (startRow==0 && startColumn==n-1) || (startRow==m-1 && startColumn==0) || (startRow==m-1 && startColumn==n-1)){
//         //     return 2;
//         // }

//         if ((startRow==-1 || startRow==m || startColumn==-1 || startColumn==n)){
//             return 1;
//         }

//         return findPaths(m,n,maxMove-1,startRow-1,startColumn)+findPaths(m,n,maxMove-1,startRow+1,startColumn)+findPaths(m,n,maxMove-1,startRow,startColumn-1)+findPaths(m,n,maxMove-1,startRow,startColumn+1);
//     }
// }
class Solution {
    public int findPaths(int m, int n, int N, int x, int y) {
        //576. Out of Boundary Paths 
        final int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[x][y] = 1;
        int count = 0;

        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                    ) % M;
                }
            }
            dp = temp;
        }

        return count;
    }
}
