class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes=0;
        int left=0;
        int right=-1;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                right++;
            }else{
                if(right>=left){
                    maxOnes=Math.max(right-left+1,maxOnes);
                }
                left=i+1;
                right=i;
            }
        }
        if(right>=left){
            maxOnes=Math.max(right-left+1,maxOnes);
        }
        return maxOnes;
    }
}


/**
 * Maintain current count and maximum count so far.
 *
 * Time Complexity: O(N)
 *
 * Space Complexity: O(1)
 *
 * N = Length of the input array
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int curCount = 0;
        int maxCount = 0;

        for (int n : nums) {
            if (n == 1) {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            } else {
                curCount = 0;
            }
        }

        return maxCount;
    }
}