// s.char is not possible. string is immutable
class Solution {
    public String maximumOddBinaryNumber(String s) {
        //2864. Maximum Odd Binary Number
        int i=0;
        for(int k=0;k<s.length();k++){
            if(s.charAt(k)=='1'){
                s.charAt(i)='1';
                s.charAt(k)='0';
                i++;
            }
        }

        s.charAt(i-1)='0';
        s.charAt(s.length()-1)='1';

        return s;

    }
}

class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        for (int k = 0; k < chars.length; k++) {
            
            if (chars[k] == '1') {
                if(i==k){
                    i++;
                    continue;
                }
                chars[i] = '1';
                chars[k] = '0';
                i++;
            }
        }

        if(i==s.length()){
            return new String(chars);
        }

        chars[i - 1] = '0';
        chars[chars.length - 1] = '1';

        return new String(chars);
    }
}

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int cnt1 = 0, cnt0 = 0;
        for (char a : s.toCharArray()) {
            if (a == '1') cnt1++;
            else if (a == '0') cnt0++;
        }
        StringBuilder ans = new StringBuilder();
        ans.append("1".repeat(cnt1 - 1));
        ans.append("0".repeat(cnt0));
        ans.append("1");
        return ans.toString();
    }
}

class Solution {
    public String maximumOddBinaryNumber(String binaryString) {
        int countOnes = 0;
        StringBuilder resultBuilder = new StringBuilder();
        
        for (char ch : binaryString.toCharArray()) {
            if (ch == '1') {
                countOnes++;
            }
        }
        
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (countOnes > 1) {
                countOnes--;
                resultBuilder.append('1');
            } else {
                resultBuilder.append('0');
            }
        }
        
        resultBuilder.append('1');
        return resultBuilder.toString();
    }
} 

// Shashank best solution
class Solution {
    public String maximumOddBinaryNumber(String s) {
        int strLen = s.length();
        int oneCount=0;
        for(int i=0; i<strLen; i++){
            if(s.charAt(i)=='1'){
                oneCount++;
            }
        }
        //String res=new StringBuilder();
        String res="";
        for(int i=0; i<strLen; i++){
            if(oneCount>1 || i== strLen-1){
                //res.append('1');
                res+="1";
                oneCount--;
            }else{
                //res.append('0');
                res+="0";
            }
        }
        return res;
        //return res.toString;
    }
}