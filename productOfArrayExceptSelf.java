class Solution {
    public int[] productExceptSelf(int[] nums) {

        //238. Product of Array Except Self
        
        int n=nums.length;
        int[] productArray=new int[n];

        // int prefix=1;

        // for(int i=0;i<n;i++){
        //     productArray[i]=prefix;
        //     prefix*=nums[i];    
        // }
        
        // can be optimized to this
        productArray[0] = 1;
        for(int i =1; i < nums.length; i++){
           productArray[i] = nums[i-1] * productArray[i-1];
        }

       // System.out.println(java.util.Arrays.toString(productArray));

        int postfix=1;

        for(int i=n-1;i>=0;i--){
            productArray[i]*=postfix;
            postfix*=nums[i];
        }

        return productArray;
        
    }
}