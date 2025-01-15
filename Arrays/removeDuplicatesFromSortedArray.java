class Solution {
    public int removeDuplicates(int[] nums) {
        //26. Remove Duplicates from Sorted Array
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

// Brute-force - Using Hashset and getting it back to arrays
// Time complexity: O(n) and Space Complexity: O(n)

// My solution - more readable, but logic in above if loop is good
// Time complexity: O(n) and Space Complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        for(int right=0; right<nums.length;right++){
            if(nums[left]!=nums[right]){
                nums[++left]=nums[right];
            }
        }
        return left+1;
    }
}   

// Bad Solution, may be mine
class Solution {
    public int removeDuplicates(int[] nums) {
        //26. Remove Duplicates from Sorted Array
        if(nums.length==0){
            return 0;
        }
        int prev=0;
        boolean change=false;
        int count=0;
        int i=0;
        while(i<nums.length){
            while(i<nums.length && nums[i]==nums[prev]){
                
                i++;
                change=true;
            }
            if(change && i<nums.length){
                count++;
                System.out.println(Arrays.toString(nums));
                System.out.println(prev+" "+i);
                nums[++prev]=nums[i];
                change=false;
            }
            else{
                i++;
                prev++;
            }
            
        }


        return count+1;
    }
}