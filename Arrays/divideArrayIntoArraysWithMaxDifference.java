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