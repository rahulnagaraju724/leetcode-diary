class Solution {
    public String firstPalindrome(String[] words) {
        //2108. Find First Palindromic String in the Array
        for(String elt:words){
            if(isPalindrome(elt)){
                return elt;
            }
        }
        return "";
        
    }

    public boolean isPalindrome(String str){
        int strLength = str.length();
        for(int i=0; i< str.length()/2;i++){
            if(str.charAt(i) != str.charAt(strLength-1-i)){
                return false;
            }
        }

        return true;

    }
}