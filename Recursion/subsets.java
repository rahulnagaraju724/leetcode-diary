// Bit Manupulation
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //78. Subsets
        int n=nums.length;
        List<List<Integer>> subsets=new ArrayList<>();
        for(int num=0;num<=(1<<n)-1;num++){
            List<Integer> subset=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((num & (1<<i))!=0){
                    subset.add(nums[i]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}

// Stiver's Another backtrack approach
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList();
        if(nums==null || nums.length==0) return result;
        
        subsets(nums,new ArrayList<Integer>(), 0);
        return result;
    }
    
    private void subsets(int[] nums, ArrayList<Integer> temp, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // main logic
		// case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, temp, index+1); // move ahead
        temp.remove(temp.size()-1);
        
		// case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
        subsets(nums, temp, index+1); // move ahead
    }
}

// Better solution using backtracking
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //78. Subsets
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList)); // Create arrayList and add it already to results
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

