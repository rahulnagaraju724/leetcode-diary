// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//          //1143. Longest Common Subsequence
//          int n=text1.length();
//          HashSet<String> set=new HashSet<>();
//          for(int num=0;num<=(1<<n)-1;num++){
//              StringBuilder s=new StringBuilder("");
//              for(int i=0;i<n;i++){
//                  if((num &(1<<i))!=0){
//                      s.append(text1.charAt(i));
//                  }
//              }
//              //System.out.println(s);
//              set.add(s.toString());
//          }

//         int maximum=Integer.MIN_VALUE;
//         //set.forEach(System.out::print);


//         int m=text2.length();
//         for(int num=0;num<=(1<<m)-1;num++){
//              StringBuilder s=new StringBuilder("");
//              for(int i=0;i<m;i++){
//                  if((num &(1<<i))!=0){
//                      s.append(text2.charAt(i));
//                  }
//              }
//              String str=s.toString();
//             if(set.contains(str)){
//                 maximum=Math.max(maximum,str.length());
//             }
//         }
//     System.out.println(m);
//     System.out.println(n);
//     return maximum;

//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //1143. Longest Common Subsequence
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
