// Sort is not preferred
class Solution {
    public int singleNumber(int[] nums) {
        //136. Single Number
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        //136. Single Number
        int result=0;
        for(int i=0; i<nums.length; i++) {
            result = result^nums[i];
        }
        return result;
    }
}