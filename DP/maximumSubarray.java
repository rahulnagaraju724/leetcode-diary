// class Solution {
//     public int maxSubArray(int[] nums) {
//         //53. Maximum Subarray
//         //int prevSum=nums[nums.length-1];
//         if(nums.length==0){
//             return 0;
//         } 
//         int maximum=nums[nums.length-1];
//         for(int i=nums.length-2;i>=0;i--){
//             nums[i]=Math.max(nums[i],nums[i]+nums[i+1]);
//             maximum=Math.max(maximum,nums[i]);
//         }
//         return maximum;
//     }
// }

class Solution {
    public int maxSubArray(int[] nums) {
        //53. Maximum Subarray
        //int prevSum=nums[nums.length-1];
        if(nums.length==0){
            return 0;
        } 
        int maximum=nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i]=Math.max(nums[i],nums[i]+nums[i-1]);
            maximum=Math.max(maximum,nums[i]);
        }
        return maximum;
    }
}