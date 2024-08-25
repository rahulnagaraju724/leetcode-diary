// Using ArrayList to keep track of used elements(works only if unique)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 46. Permutations
        // Not a good solution, only works if unique elements in array so it's wrong
        List<List<Integer>> results=new ArrayList<>();   
        backtrack(nums,results,new ArrayList<>()); 
        return results;
    }
    public void backtrack(int[] nums,List<List<Integer>> results, List<Integer> tempList){
        if(tempList.size()==nums.length){
            results.add(new ArrayList<>(tempList));
        }
        for(int number: nums){
            if(tempList.contains(number)){
                continue;
            }
            tempList.add(number);
            backtrack(nums,results,tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}

// Using visited array to keep track of indexes visited in nums
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> permuteArray=new ArrayList<>();
        int[] visited=new int[nums.length];
        permute(results,nums,visited,permuteArray);
        return results;
    }
    public void permute(List<List<Integer>> results, int[] nums,int[] visited,List<Integer> permuteArray){
        if(permuteArray.size()==nums.length){
            //results.add(permuteArray);    Maajor problem, adding as reference
            results.add(new ArrayList<>(permuteArray)) ;       
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                permuteArray.add(nums[i]);
                visited[i]=1;

                permute(results,nums,visited,permuteArray);

                visited[i]=0;
                permuteArray.remove(permuteArray.size()-1);
            }
        }
        
    }
}

// Using swapping and no extra space -> Striver apporach
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        permute(results,nums,0);
        return results;
    }
    public void permute(List<List<Integer>> results, int[] nums,int index){
        if(index==nums.length){
            //results.add(nums);    Maajor problem, adding as reference
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            results.add(permutation);     
        }

        for(int i=index;i<nums.length;i++){
            swap(nums,i,index);
            permute(results,nums,index+1);
            swap(nums,i,index); //most important backtrack by swapping back
        }
        
    }

    public void swap(int[]nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}