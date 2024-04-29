// O(n2) solution
class Solution {
    public int findDuplicate(int[] nums) {
        //287. Find the Duplicate Number
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return 0;
    }
}

// This is constant extra space as space is fixed already
class Solution {
    public int findDuplicate(int[] nums) {
        //287. Find the Duplicate Number
        boolean[] nums2=new boolean[nums.length-1];
        for(int num:nums){
            if(nums2[num-1]){
                return num;
            }
            nums2[num-1]=true;
        }
        return 0;
    }
}