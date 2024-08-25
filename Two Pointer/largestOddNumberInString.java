class Solution {
    public String largestOddNumber(String num) {
        //1903. Largest Odd Number in String
        if(num.length()==0){
            return "";
        }

        int left=0;
        int right=num.length()-1;

        while(left<=right){
            if(num.charAt(right)=='2' || num.charAt(right)=='4' || num.charAt(right)=='6' || num.charAt(right)=='8' || num.charAt(right)=='0'){
                right--;
            }
            else{
                return num.substring(left,right+1);
            }
        }
        return "";
    }
}