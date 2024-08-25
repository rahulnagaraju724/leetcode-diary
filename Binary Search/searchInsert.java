class Solution {
    public int searchInsert(int[] nums, int target) {
        //35. Search Insert Position
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle=left+(right-left)/2;
            System.out.println(left+" "+middle+" "+right);
            if(nums[middle]==target){
                return middle;
            }
            // Simple solution, I only made it complex by thinking too much
            // if((left==right) && nums[left]<target){
            //     return left+1;
            // }
            // else if((left==right) && nums[left]>target){
            //     return left-1;
            // }
            if(nums[middle]<target){
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        System.out.println("End of function");
        return left;
        //return right; // Why should we return only left
    }
}