class Solution {
    //2971. Find Polygon With the Largest Perimeter
    public long largestPerimeter(int[] nums) {
        if(nums.length <3) return -1;
        Arrays.sort(nums);
        int j=0;
        while(nums.length-j >=3){
            long sum=0;
            for(int i=0; i<nums.length-1 -j; i++){
                if(nums[i]<0) return -1;
                sum +=nums[i];
            }
            if( sum > nums[nums.length-1-j] ){
                return sum+nums[nums.length-1-j];
            }
            j++;
        }
            return -1;
    }
}
