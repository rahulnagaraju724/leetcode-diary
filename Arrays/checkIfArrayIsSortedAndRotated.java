class Solution {
    public boolean check(int[] nums) {
        // Does not work for [2,1,3,4]
        int n=nums.length;
        if(n<2){
            return true;
        }

        int check=1;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                if(check==1){
                    check=1;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }



n