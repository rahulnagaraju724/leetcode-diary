/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        //278. First Bad Version
    // Too much time taking
    //   for(int i=1;i<=n;i++){
    //        System.out.println(isBadVersion(i));
    //       if(isBadVersion(i)){
    //           return i;
             
    //       }
    //   }  

        int left=1;
        int right=n;
        int version=n;
        while(left<=right){
            int middle=left+(right-left)/2;
            // System.out.println(middle);
            // if(isBadVersion(middle) && !isBadVersion(middle-1)){ //but this increased run time
            //     return middle; 
            // }
            if(isBadVersion(middle)){
                right=middle-1;
                version=middle;
            }
            else{
                left=middle+1;
            }
        }
      return version;
    }
}