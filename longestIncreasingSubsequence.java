class Solution {
    public int lengthOfLIS(int[] nums) {
        // 300. Longest Increasing Subsequence
        int n=nums.length;
        int[] LIS=new int[n];
        Arrays.fill(LIS,1);

        int max=1;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                if(nums[i]<nums[j]){
                    int value = Math. max(LIS[i],1+LIS[j]);
                    LIS[i]=value;
                    if(value>max){
                        max=value;
                    }
                }
            }
        } 
        //System.out.println(Arrays.toString(LIS));

        return max;
    }


}