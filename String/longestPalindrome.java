class Solution {
    public int longestPalindrome(String s) {
        //409. Longest Palindrome
        HashMap<Character, Integer> count=new HashMap<>();
        for(int i=0;i<s.length();i++){
            count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0)+1);            
        }

        int length=0;
        int singlePresent=0;

        for (int value : count.values()) {
            if(value%2==1){
                singlePresent=1;
                length+=value-1;
            }else{
                length+=value;
            }

        }

        return length+singlePresent;

    }
}