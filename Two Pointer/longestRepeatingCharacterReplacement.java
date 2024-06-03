class Solution {
    public int characterReplacement(String s, int k) {
        //424. Longest Repeating Character Replacement

        int left=0;
        int right=0;
        int count=0;
        int length=0;
        // System.out.println("new problem:"+s);
        while(right<s.length()){
            // System.out.println(left+","+right);
            if(s.charAt(right)!=s.charAt(left)){
                if(count<k){
                    count++;
                    right++;
                    length=Math.max(length,right-left);
                }else if(count>=k){ // Doesn't work for "ABBB"
                    while(left<s.length()-1 && s.charAt(left)==s.charAt(left+1)){
                        left++;
                    }
                    left++;
                    right=left;
                    count=0;
                }
            }
            else{
                right++;
                length=Math.max(length,right-left);
            }
        }
        return length;
    }
}