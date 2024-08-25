class Solution {
    public boolean isPalindrome(String s) {

        //125. Valid Palindrome
        

        // Use regular expression to match all non-alphabetic plus numeric characters and replace with empty string
        String result = s.replaceAll("[^a-zA-Z0-9]", "");

        // System.out.println(result);

        String finalResult=result.toLowerCase();
        // System.out.println(finalResult);

        int n=finalResult.length();
        int i=0;
        while(i<n/2){
            if(finalResult.charAt(i)!=finalResult.charAt(n-i-1)){
                return false;
            }
            i++;
        }

        return true;

    }
}
// More optimized one
class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(String s) {
        int start = 0; 
        int end = s.length() - 1;
        while(start <= end) {
            while(start <= end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while(start <= end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if(start <= end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}