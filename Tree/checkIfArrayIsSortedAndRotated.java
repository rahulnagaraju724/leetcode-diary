// Brute-force
class Solution {
    public boolean check(int[] nums) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i])
                return false;
            }
        }

        return true;
    }
}

// Good approach
class Solution {
    public boolean check(int[] nums) {        
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }
}

// My solution 
// Time complexity: O(n) and Space Complexity: O(1)
class Solution {
    public boolean check(int[] nums) {
        // 1752. Check if Array Is Sorted and Rotated
        // Does not work for [2,4,1,3]
        int n=nums.length;
        if(n<2){
            return true;
        }

        int check=1;
        int rotatePoint=0;

        for(int i=1;i<n;i++){
            if(nums[i]<nums[i-1]){
                if(check==1){
                    check=0;
                    rotatePoint=nums[i-1];
                }
                else{
                    return false;
                }
            }
        }
        if(check==0){
            if(rotatePoint>=nums[n-1] && nums[0]>=nums[n-1] ){
                return true;
            }
            else{
                return false;
            }
        }

        return true;
    }
}

// Good approach
class Solution {
    public boolean check(int[] nums) {
        // here we compare all the neighbouring elemnts and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        int length = nums.length;
        for (int i=0; i<length; i++) {
            if (nums[i] > nums[(i + 1) % length])
                irregularities += 1;
        }
        return irregularities > 1 ? false : true;
    }
}