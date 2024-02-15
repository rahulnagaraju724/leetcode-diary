class Solution {
    public int[] twoSum(int[] nums, int target) {
        //1. Two Sum
        // can also be done by sorting the array, and then finding target-x
        HashMap<Integer,Integer> numsMap=new HashMap<>();
        int[] result=new int[2];

        for(int i=0;i<nums.length;i++){
            int req=target-nums[i];
            if(numsMap.containsKey(req)){
                if(numsMap.get(req)!=i){//Think this line is not required
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

//Brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{}; // No solution found
    }
}

//Two pass Hash
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        // Build the hash table
        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        // Find the complement
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{}; // No solution found
    }
}