class Solution {
    public int minimumLength(String s) {
        //1750. Minimum Length of String After Deleting Similar Ends
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return right-left+1;
            }

            char ch=s.charAt(left);

            while(left<s.length() && left<=right && s.charAt(left)==ch){ // our code was left<right
                left++;
            }
            while(right>0 && left<right && s.charAt(right)==ch){ // our code was left<right
                right--;
            }
            
            // if(left==right-1 && s.charAt(left)==s.charAt(right) ){
            //     return 0;
            // }

        }
        return left>right? 0:right-left+1; // how can left go above right
        //return left==right? 0 : right-left+1; // our previous logic
    }
}

// Best
class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);
            while (l <= r && s.charAt(l) == ch) l++;
            while (l <= r && s.charAt(r) == ch) r--;
        }
        return (l > r) ? 0 : r - l + 1;
    }
}