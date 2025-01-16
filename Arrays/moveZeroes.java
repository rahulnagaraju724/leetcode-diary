// My solution
// Not needed of complex solution to count zeroes and all, see below solution
class Solution {
    public void moveZeroes(int[] nums) {
        // 283. Move Zeroes
        int n=nums.length;
        int zeroCount=0;
        int indexLastNonZero=0;
        int left=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[++left]=nums[i];
                indexLastNonZero=i;
            }
            else{
                zeroCount++;
            }
        }
        
        // Now add zeroes
        for(int k=0;k<zeroCount && left+1<n ;k++){
            nums[++left]=0;
        }

        return;
    }
}

// Shift non-zero values as far forward as possible
// Fill remaining space with zeros

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;        

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }        

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}

// Snowball solution
class Solution {
     public void moveZeroes(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}