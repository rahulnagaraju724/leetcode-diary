class Solution {
    public long largestPerimeter(int[] nums) {
        //2971. Find Polygon With the Largest Perimeter
        Arrays.sort(nums);
        long sum=-1;
        for(int j=nums.length-1;j>=2;j--){
            sum=0;
            for(int i=j-1;i>=0;i--){
                sum+=nums[i];
            }
            if(sum>nums[j]){
                return sum+nums[j];
            }
        }  
        
        return -1;
        }

    
}


// Nice thought
class Solution {
    public long largestPerimeter(int[] nums) {
        long sum = 0;
        Arrays.sort(nums);
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        for (int i = n - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
        }
        return -1;
    }
}
