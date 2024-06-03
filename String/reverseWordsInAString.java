class Solution {
    public String reverseWords(String s) {
        //151.Reverse Words in a String
        int left=s.length()-1;
        int right=left+1;
        if(right==0){
            return "";
        }
        StringBuilder str=new StringBuilder();
        while(left>=0){
            if(s.charAt(left)==' '){
                // System.out.println(left+", "+right);
                if(left+1==right){
                    right--;
                    left--;
                    continue;
                }
                str.append(s.substring(left+1,right));
                str.append(" ");
                right=left;                
            }
            left--;
        }
        if(right>left){ // still first word not added
            str.append(s.substring(left+1,right));
        }
        
        if(str.charAt(str.length()-1)==' '){
            str.setLength(Math.max(str.length() - 1, 0));
        }

        return str.toString();

    }
}