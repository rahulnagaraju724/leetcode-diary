// Not a good solution
class Solution {
    public int longestOnes(int[] nums, int k) {
        //1004. Max Consecutive Ones III
        // System.out.println("----------------New Problem--------------------");
        int i = 0, j = 0, n = nums.length;
        int res = 0;

        while (i < n) {
            int tempCount = k;
            int firstZeroIndex = -1;
            j = i;
            while (j < n) {

                if (nums[j] != 1 && tempCount > 0) {
                    if (tempCount == k) {
                        firstZeroIndex = j;
                    }
                    tempCount--;
                } else if (nums[j] != 1 && tempCount == 0) {
                    break;
                }
                j++;
            }

            res = Math.max(res, j - i);
            System.out.println("i :" +i +" j :" +j + " firstZeroIndex :" +firstZeroIndex);
            i =( firstZeroIndex == -1 || firstZeroIndex == i? j : firstZeroIndex );


        }
        return res;
    }
}

// Better approach
class Solution {
    public int longestOnes(int[] nums, int k) {
        ////1004. Max Consecutive Ones III
        int i = 0, j = 0, n = nums.length;
        int res = 0;
        int tempCount = k;

        while (j < n) {

            if (nums[j] != 1 && tempCount > 0) {
                tempCount--;
            } else if (nums[j] != 1 && tempCount == 0) {
                res = Math.max(res, j - i);
                while(nums[i]!=0){
                    i++;
                }
                i++;
                tempCount++;
                continue;// This is to not increment j
            }
            j++;
        }

        res = Math.max(res, j - i);

        return res;
    }
}
