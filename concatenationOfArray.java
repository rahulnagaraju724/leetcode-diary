class Solution {
    public int[] getConcatenation(int[] nums) {
        //1929. Concatenation of Array
        int n=nums.length;
        if(n<1){ // not needed, just trying to decrease runtime
            return nums;
        }
        int ans[]=new int[n*2];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[i+n]=nums[i];
        }
        return ans;
    }
}