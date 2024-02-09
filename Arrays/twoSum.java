class Solution {
    public int[] twoSum(int[] nums, int target) {
        //1. Two Sum
        // can also be done by sorting the array, and then finding target-x
        HashMap<Integer,Integer> numsMap=new HashMap<>();
        int[] result=new int[2];

        for(int i=0;i<nums.length;i++){
            int req=target-nums[i];
            if(numsMap.containsKey(req)){//Think this line is not required
                if(numsMap.get(req)!=i){
                    result[0]=i;
                    //System.out.println(i+ " "+numsMap.get(req));
                    result[1]=numsMap.get(req);
                    //numsMap.forEach((key, value) -> System.out.println(key + " " + value));
                    return result;
                }
            }

            numsMap.put(nums[i],i);
        }


        return result;
    }
}