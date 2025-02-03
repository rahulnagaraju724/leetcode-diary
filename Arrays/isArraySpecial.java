// class Solution {
//     public boolean isArraySpecial(int[] nums) {
//         for(int i=0;i<nums.length-1;i++){
//             int curr=nums[i]%2;
//             int next=nums[i+1]%2;
//             if((curr^next )== 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean isArraySpecial(int[] nums) {
        int prev=nums[0]%2;
        for(int i=1;i<nums.length;i++){
            int curr=nums[i]%2;
            if((prev^curr)== 0){
                return false;
            }
            prev=curr;
        }
        return true;
    }
}