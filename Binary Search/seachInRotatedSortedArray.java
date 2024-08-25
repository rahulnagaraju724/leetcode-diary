class Solution {
    public int search(int[] nums, int target) {
        // 33. Search in Rotated Sorted Array
        return indexSearch(nums,target,0,nums.length-1);
    }

    public int indexSearch(int[] nums, int target, int left, int right){
        if(left<=right){
            int middle=(left+(right))/2;
            if(target==nums[middle]){
                return middle;
            }
            if(nums[left]<=nums[middle]){// To check if middle is in left sorted array
                if(target>nums[middle]){ // right part of left sorted array
                    left=middle+1;
                    return indexSearch(nums,target,left,right);
                }
                else if(target<nums[left]){ // plus target<nums[middle], it's in right sorted array
                    left=middle+1;
                    return indexSearch(nums,target,left,right);
                }
                else{//not above condition i.e, target lies in left sorted array
                    right=middle-1;
                    return indexSearch(nums,target,left,right);
                }
            }
            else{ // To check if middle is in right sorted array
                if(target<nums[middle]){
                    right=middle-1;
                    return indexSearch(nums,target,left,right);
                }
                else if (target>nums[right]){// plus target>nums[middle], it's in left sorted array
                    right=middle-1;
                    return indexSearch(nums,target,left,right);
                }
                else{//not above condition i.e, target lies in right sorted array
                    left=middle+1;
                    return indexSearch(nums,target,left,right);
                }
            }
        }
        return -1;
    }
}