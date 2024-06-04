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
            //    System.out.println("Here1");
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
            //    System.out.println("Here2");
           }
        
       } 

        return s.substring(lP,rP+1);

    }
}

// Wrong - but first approach
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int mid=s.length()/2;
        int left=0;
        int right=0;
        int highestLength=0;
        if(n%2==1){
            left=mid-1;
            right=mid+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            highestLength=Math.max(highestLength,(right-1)-(left+1)+1);
            return s.substring(left+1,right);
        }else{
            left=mid-1;
            right=mid;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                left--;
                right++;
            }
            highestLength=Math.max(highestLength,(right-1)-(left+1)+1);           
        }
        return s.substring(left+1,right);
        // return "";
    }
}

// Wrong - but second approach
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }
        // int mid=s.length()/2;

        int left=0;
        int right=0;

        int highestLength=0;
        String longestPalindrome="";

        for(int mid=0;mid<n;mid++){
            if(mid%2==1){ //even middle means odd length
                left=mid;
                right=mid;
                while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                if(highestLength<((right-1)-(left+1)+1)){
                    longestPalindrome=s.substring(left+1,right);
                    highestLength=(right-1)-(left+1)+1;
                }
                
            }else{
                left=mid-1;
                right=mid;
                while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    left--;
                    right++;
                }
                if(highestLength<((right-1)-(left+1)+1)){
                    longestPalindrome=s.substring(left+1,right);
                    highestLength=(right-1)-(left+1)+1;
                }
            }
        }
        
        return longestPalindrome;
        // return "";
    }
}

// Wrong - but third amendment
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }
        // int mid=s.length()/2;

        int left=0;
        int right=0;

        int highestLength=0;
        String longestPalindrome="";

        for(int mid=0;mid<n;mid++){
            if(mid%2==1){ //even middle means odd length
                left=mid;
                right=mid;
                while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    if(highestLength<((right)-(left)+1)){
                        longestPalindrome=s.substring(left,right+1);
                        highestLength=(right)-(left)+1;
                    }
                    left--;
                    right++;
                }
                
                
            }else{
                left=mid-1;
                right=mid;
                while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                    if(highestLength<((right)-(left)+1)){
                        longestPalindrome=s.substring(left,right+1);
                        highestLength=(right)-(left)+1;
                    }
                    left--;
                    right++;
                }
            }
        }
        
        return longestPalindrome;
        // return "";
    }
}

// Brute-force approach
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

// Same as my approach
public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }
            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}