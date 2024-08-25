class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //1071. Greatest Common Divisor of Strings
        int i=0;
        while(i<str1.length() && i<str2.length() && str1.charAt(i)==str2.charAt(i)){
            i++;
        }

        if(i==0){
            return "";
        }

        if(str1.length()==str2.length() && i==str1.length()){
            return str1; //or str2
        }

        if(str2.length()==i){
            return gcdOfStrings(str1.substring(i,str1.length()), str2);
        }

        return gcdOfStrings(str1, str2.substring(i,str2.length()));
    }
}

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // Check if concatenated strings are equal or not, if not return ""
        if (!(str1 + str2).equals(str2 + str1))
            return "";
        // If strings are equal than return the substring from 0 to gcd of size(str1), size(str2)
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}