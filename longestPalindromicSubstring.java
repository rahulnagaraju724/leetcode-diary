class Solution {
    public String longestPalindrome(String s) {
        //5. Longest Palindromic Substring
        int longest=0;
        int lP=0,rP=0;// to hold indexes of the palindrome
       for(int i=0;i<s.length();i++){
           int left=i-1, right=i+1;
           while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
               left--;
               right++;
           }
           if(longest<((right-1)-(left+1)+1)){ // Can we do this in one sep method?
               longest=((right-1)-(left+1)+1);
               lP=left+1;
               rP=right-1;
               System.out.println("Here");
           }
           //check for even substring length
           left=i;
           right=i+1;
           while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
               left--;
               right++;
           }
           if(longest<((right-1)-(left+1)+1)){ // Can we do this in one sep method?
               longest=((right-1)-(left+1)+1);
               lP=left+1;
               rP=right-1;
               System.out.println("Here");
           }
        
       } 

        return s.substring(lP,rP+1);

    }
}