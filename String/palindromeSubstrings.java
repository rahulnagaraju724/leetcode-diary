class Solution {
    public int countSubstrings(String s) {
        //647. Palindromic Substrings
      int count=0;
      for(int i=0;i<s.length();i++){
          for(int j=s.length()-1;j>=i;j--){
            boolean isPalindrome=true;
            int m=i;
            int n=j;
            while(m<=n && isPalindrome){
                if(s.charAt(m)!=s.charAt(n)){
                    //break;
                    isPalindrome=false;
                }
                m++;
                n--;
            }
            if(isPalindrome){
                count++;
            }
        }

      }  
      return count;
    }
}


// Two pointer approach
class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int odd = 0;
        int even = 0;
        for(int k = 0; k < s.length(); k++)
        {
            odd += checking(s, k, k);
            even += checking(s, k, k + 1);
        }
        return odd + even;
    }

    public int checking(String s, int left, int right)
    {
        int count = 0;
        while(left <= right && left >= 0 && right < s.length() &&  s.charAt(left) == s.charAt(right))
        {
            count++;
            left--;
            right++;
        }
        return count;
    }
}

//DP Approach
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int k = n -1; k >= 0; k--)
        {
            for(int j = k; j < n; j++)
            {
                if(s.charAt(k) == s.charAt(j) && (j - k < 2 || dp[k+1][j-1]))
                {
                    dp[k][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
}