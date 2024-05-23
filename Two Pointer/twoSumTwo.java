class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //167. Two Sum II - Input Array Is Sorted
        int[] result=new int[2];
        int left=0;
        int right=numbers.length-1;
        while(left<right){
            if(numbers[left]+numbers[right]<target){
                left++;
            }
            else if(numbers[left]+numbers[right]>target){
                right--;
            }
            else{
                
                result[0]=left+1;
                result[1]=right+1;
                return result;
            }
        }


        return result;
    }
}

// Initially I thought this solution only
public int[] twoSum_bs(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; ++i) {
        int low = i + 1;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (numbers[mid] == target - numbers[i]) {
                return new int[]{i + 1, mid + 1};
            } else if (numbers[mid] > target - numbers[i]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
    return new int[]{-1, -1};
}