class Solution {
    public boolean check(int[] nums) {
        // Does not work for [2,1,3,4], but now it works
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

        // Now, this logic works
        if(check==0){
            if(nums[0]<nums[n-1]){
                return false;
            }
        }

        return true;
    }
    
//More readable solution

class Solution {
    public boolean check(int[] arr) {
        int drop = 0;
        for(int i = 1; i < arr.length; i++){
            // Count drops where the current element is greater than the next one
            if(arr[i - 1] > arr[i]){
                drop++;
            }
        }

        // Check if there is a drop from the last element to the first element
        if(arr[0] < arr[arr.length - 1]) drop++;
        
        // The array is sorted or can be sorted with at most one rotation if drop count <= 1
        return drop <= 1;
    }
}