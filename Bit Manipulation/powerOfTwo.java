class Solution {
    public boolean isPowerOfTwo(int n) {
        //231. Power of Two
        if(n==1){
            return true;
        }
        if(n%2==1){
            return false;
        }

        int i=1;
        while(Math.pow(2,i)<n){
            i++;
        }
        return Math.pow(2,i)==n;

    }
}

public boolean isPowerOfTwo(int n) {
    //231. Power of Two
    if(n<=0)
        return false;
    return ((n&(n-1))==0);
}