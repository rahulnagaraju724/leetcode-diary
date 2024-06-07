class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //1296. Divide Array in Sets of K Consecutive Numbers
        // Not working
        int n=nums.length;
        if(n%k!=0){
            return false;
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        int small=nums[0];
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(nums[i]<small){
                small=nums[i];
            }
        }
        while(!map.isEmpty()){
            int currentSmall=small;
            boolean repeated=false;
            for(int i=0;i<k;i++){

                if(!map.containsKey(currentSmall+i)){
                    System.out.println("Returning false here:" + currentSmall+", "+i);
                    System.out.println("Prinintg map here"+map.toString());
                    return false;
                }

                int value=map.get(currentSmall+i);
                value=value-1;
                map.put(currentSmall+i,value); 

                if(value!=0 && !repeated){
                    repeated=true;
                    System.out.println(" Before Assigning small here:" + small);
                    small=currentSmall+i;
                    System.out.println("Assigning small here:" + currentSmall+","+i);
                    
                }
                if(value==0){
                    map.remove(currentSmall+i);
                }
            }


            if(!repeated){
                small=small+k;
            }

        }

        return true;

    }
}

// Working solution
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        //1296. Divide Array in Sets of K Consecutive Numbers
        int n=nums.length;
        if(n%k!=0){
            return false;
        }
        HashMap<Integer, Integer> map=new HashMap<>();
        // int small=nums[0];
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            // if(nums[i]<small){
            //     small=nums[i];
            // }
        }
        while(!map.isEmpty()){
            // int currentSmall=small;
            // boolean repeated=false;
            int currentSmall = Collections.min(map.keySet());
  
            for(int i=0;i<k;i++){

                if(!map.containsKey(currentSmall+i)){
                    System.out.println("Returning false here:" + currentSmall+", "+i);
                    System.out.println("Prinintg map here"+map.toString());
                    return false;
                }

                int value=map.get(currentSmall+i);
                value=value-1;
                map.put(currentSmall+i,value); 

                // if(value!=0 && !repeated){
                //     repeated=true;
                //     System.out.println(" Before Assigning small here:" + small);
                //     small=currentSmall+i;
                //     System.out.println("Assigning small here:" + currentSmall+","+i);
                    
                // }
                if(value==0){
                    map.remove(currentSmall+i);
                }
            }


            // if(!repeated){
            //     small=small+k;
            // }

        }

        return true;

    }
}

// Same as mine above
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = Collections.min(map.keySet());
            for (int i = first; i < first + k; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                map.put(i, map.get(i) - 1);
                if (map.get(i) == 0) {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}

// Most optmised code
class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);

        for (int num : nums) {
            if (map.get(num) > 0) {
                for (int i = num + 1; i < num + k; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    map.put(i, map.get(i) - 1);
                }
                map.put(num, map.get(num) - 1);
            }
        }

        return true;
    }
}

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Integer i : nums){
            pq.add(i);
        }
        
        while(!pq.isEmpty()){
            int curr = pq.poll();
            for(int j=1; j<k; j++){
                if(!pq.remove(curr + j)) return false;
            }
        }
        return true;
    }
}