class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        //930. Binary Subarrays With Sum
        int count=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            //System.out.println("i:"+i);
            for(int j=i;j<nums.length;j++){
                //System.out.println("\tj:"+j);
                sum+=nums[j];
                if(sum==goal){
                    count++;
                }
                else if(sum>goal){
                    break;
                }
            }

        }
        return count;
    }
}