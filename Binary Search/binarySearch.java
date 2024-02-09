class Solution {
    public int search(int[] nums, int target) {
       return indexSearch(nums,target,0,nums.length-1,nums.length/2); 
    }

    public int indexSearch(int[]nums, int target, int left, int right, int middle){
        // 704. Binary Search
        if(left<=right){
            if(target==nums[middle]){
                return middle;
            }else if(target<nums[middle]){
                right=middle-1;
                middle=(left+right)/2;
                return indexSearch(nums,target,left,right,middle);
            }else{
                left=middle+1;
                middle=(left+right)/2;
                return indexSearch(nums,target,left,right,middle);
                
            }
        }
        return -1;
    }
}