class Solution {
    public String mergeAlternately(String word1, String word2) {
        //1768. Merge Strings Alternately
        int i=0;
        int j=0;
        //String s="";
        StringBuilder result = new StringBuilder();
        while(i<word1.length() && j< word2.length()){
            //s=s+word1.charAt(i)+word2.charAt(j);
            result.append(word1.charAt(i));
            result.append(word2.charAt(j));
            i++;
            j++;
        }

        if(i<word1.length()){
            //   s=s+word2.substring(i,word1.length());
            result.append(word1.substring(i,word1.length()));
        }
        if(j<word2.length()){
              //s=s+word2.substring(j,word2.length());
               result.append(word2.substring(j,word2.length()));
        }

        return result.toString();
    }
}