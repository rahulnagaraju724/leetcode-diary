class Solution {
    public int[][] divideArray(int[] nums, int k) {
        //2966. Divide Array Into Arrays With Max Difference
        Arrays.sort(nums);
        int[][] results=new int[nums.length/3][3];
        for(int i=0;i<nums.length;i=i+3){
            //if(Math.abs(nums[i]-nums[i+1]) <=k && Math.abs(nums[i]-nums[i+2]) <=k && Math.abs(nums[i+1]-nums[i+2]) <=k){
            if (Math.abs(nums[i] - nums[i + 2]) <= k) { //Kamaal ka logic yaar

                results[i/3][0]=nums[i];
                results[i/3][1]=nums[i+1];
                results[i/3][2]=nums[i+2];  
            }else{
                return new int[][]{};
            }

        }
        return results;
    }
}

// One more approach, but not better

public class Solution
{
public int[][] divideArray(int[] nums, int k)
    {
        // Calculate the number of subarrays to be created
        int numArrays = (int)Math.ceil(nums.length / 3.0);
        // Initialize a 2D array to store the divided arrays
        int[][] ans = new int[numArrays][3];
        // Initialize an array to store the frequency of each element
        int[] frequency = new int[100001];
        // Find the maximum element in the array
        int maximum = 0;
        for (int num : nums)
        {
            frequency[num]++;
            maximum = Math.max(num, maximum);
        }
        // Initialize an array to temporarily store a partition of the array
        int[] partition = new int[3];
        int partitionIndex = 0, index = 0; // Tracks the current position in the partition array

        // Iterate from 1 to the maximum element
        for (int i = 1; i <= maximum; i++)
        {
            // Check if the element exists in the array
            if (frequency[i] != 0)
            {
                // Repeat for the frequency of the current element
                for (int j = 0; j < frequency[i]; j++)
                {
                    // If the partition size is less than 3, add the current element
                    if (partitionIndex < 3)
                        partition[partitionIndex++] = i;
                    else
                    {
                        // Check if the difference between the maximum and minimum elements in the partition is within k
                        if (partition[2] - partition[0] <= k)
                        {
                            ans[index][0] = partition[0];
                            ans[index][1] = partition[1];
                            ans[index++][2] = partition[2];
                            partition = new int[3];
                            partition[0] = i;
                            partitionIndex = 1;
                        }
                        else
                            // If not, return an empty array
                            return new int[0][0];
                    }
                }
            }
        }

        // Check if the last partition satisfies the condition and add it to the result
        if (partition[2] - partition[0] <= k)
        {
            ans[index][0] = partition[0];
            ans[index][1] = partition[1];
            ans[index][2] = partition[2];
        }
        else
            return new int[0][0];
        return ans;
    }
}