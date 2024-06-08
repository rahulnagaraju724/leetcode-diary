class Solution {
    public void reverseString(char[] s) {
        // 344. Reverse String
        int i=0;
        int n=s.length;
        while(i<(n/2)){
            char temp=s[i];
            s[i]=s[n-1-i];
            s[n-1-i]=temp;
            i++;
        }
        return;
    }
}