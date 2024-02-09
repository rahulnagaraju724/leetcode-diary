import java.math.BigInteger;

class Solution {
    public int myAtoi(String s) {
        // 8. String to Integer (atoi)
        if(s.length()==0){
            return 0;
        }

        boolean isPositiveSign=true;
        int startIndex=-1;
        int endIndex=-1;

        for(int i=0;i<s.length() && startIndex==-1 ;i++){
            while(i<s.length() && Character.isWhitespace(s.charAt(i))){ // Did mistake not taking length consideration
                i++;
            }
            if(i<s.length() && s.charAt(i)=='-'){
                isPositiveSign=false;
                i++;
            }else if(i<s.length() && s.charAt(i)=='+') {//IMP without this, startIndex starts with +
                i++;
            }

            if(i<s.length() && (int) s.charAt(i)>=48 && (int) s.charAt(i)<=57){
                //System.out.println(s.charAt(i));
                startIndex=i;
            }else{ // Special case when words are there in the beginning
                return 0;
            }           

        }//end for loop

        endIndex=startIndex;
        // Continue till digits are ended, endIndex is exclusive
        while(endIndex<s.length() && (int) s.charAt(endIndex)>=48 && (int) s.charAt(endIndex)<=57 ){
            //System.out.println("i :"+i);
            endIndex++;
        }
        
        // System.out.println(startIndex);
        // System.out.println(endIndex);

        if(startIndex==-1 || startIndex>=s.length() || endIndex>s.length()){
            return 0;
        }

        if(!isPositiveSign){
            // return (int) Math.max(Integer.MIN_VALUE, Long.parseLong(s.substring(startIndex-1,endIndex)));
            return (int) Math.max(Integer.MIN_VALUE, new BigInteger(s.substring(Math.max(0, startIndex - 1), endIndex)).max(BigInteger.valueOf(Integer.MIN_VALUE)).longValue());

        }

        //return (int) Math.min(Integer.MAX_VALUE, Long.parseLong(s.substring(startIndex,endIndex)));
        return (int) Math.min(Integer.MAX_VALUE, new BigInteger(s.substring(startIndex, endIndex)).min(BigInteger.valueOf(Integer.MAX_VALUE)).longValue());

    }
}


//  Better solution

class Solution {
    public int myAtoi(String str) {
        
        final int len = str.length();
        
        if(len == 0){
            return 0;
        }
        
        int index = 0;
        while(index < len && str.charAt(index) == ' '){
            index++;
        }
        
        if(index == len){
            return 0;
        }
        
        char ch;
        boolean isNegative = (ch = str.charAt(index)) ==  '-';
        
        if(isNegative || ch == '+'){
            ++index;
        }
            
        final int maxLimit = Integer.MAX_VALUE / 10;
        int result = 0;
        while(index < len && isDigit(ch = str.charAt(index))){
            
            int digit = ch - '0';
            
            // if(result > maxLimit || (result == maxLimit && digit > 7)){
            //     return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            // }
            // Still more better approach
            if(result > (Integer.MAX_VALUE - digit) / 10)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            result = (result * 10) + digit;
            
            ++index;
        }
        
        return isNegative ? -result : result;
    }
    
    private boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
}