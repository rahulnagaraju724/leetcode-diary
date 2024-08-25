class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //15. 3Sum
        Arrays.sort(nums);// But is sorting a good option?

        List<List<Integer>> result=new ArrayList<>();

        int sum=0,left=0,right=0;

        for(int i=0;i<nums.length;i++){ // Actually can do this i<nums.length-2 , but ok

            if(i>0 && nums[i]==nums[i-1]){ // This is to avoid duplicates -> i>0 bcz of checking in array prev element
                continue;
            }
            
            left=i+1;
            right=nums.length-1;

            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                }
                else if(sum>0){
                    right--;
                }
                else{
                    List<Integer> innerList = Arrays.asList(nums[i],nums[left],nums[right]);
                    result.add(innerList);
                    left++;
                    while(nums[left]==nums[left-1] && left<right){
                        left++;
                    }

                }
            }
        }

        return result;
    }
}