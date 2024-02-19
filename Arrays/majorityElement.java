class Solution {
    public int majorityElement(int[] nums) {
         //169. Majority Element
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);

        int maximumElement=nums[0];
        int maximumCount=1;
        int element=nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++){
            //System.out.println("i: "+i+" nums[i]: "+nums[i]);
            if(nums[i]==element){
                count++;
            }else{
                if(count>maximumCount){
                    maximumElement=element;
                    maximumCount=count;
                }
                element=nums[i];
                count=1;
                
            }
        }
                if(count>maximumCount){
                    maximumElement=element;
                    maximumCount=count;
                }        

        return maximumElement;
    }
}

// Next level solution
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}

// Voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        return candidate;
    }
}


// One more approach
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        n = n / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        
        return 0;
    }
}