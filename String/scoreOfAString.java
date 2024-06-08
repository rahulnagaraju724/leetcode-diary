class Solution {
    public int scoreOfString(String s) {
        //3110. Score of a String
        int totalSum=0;
        for(int i=0;i<s.length()-1;i++){
            totalSum+=Math.abs(s.charAt(i)-s.charAt(i+1));
        }
        return totalSum;
    }
}