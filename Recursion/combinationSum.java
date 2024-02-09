// Not a solution
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 39. Combination Sum
        // Not a solution please read this
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> numberList=new ArrayList<>();
        backTrack(candidates,target,0,resultList,numberList);
        return resultList;
    }

    public void backTrack(int[] candidates,int target,int sum,List<List<Integer>> resultList, List<Integer> numberList){
        if(sum==target){
            System.out.println(sum +" and Array is "+numberList);
            resultList.add(numberList);
            return;
        }
        for(int i=0;i<candidates.length;i++){
            if(sum<target){
                sum+=candidates[i];
                numberList.add(candidates[i]);
                System.out.println("Here i: "+i+" Sum= "+sum+" "+Arrays.toString(numberList.toArray()));
                backTrack(candidates,target,sum,resultList,numberList);
                sum=-numberList.size()-1;
                numberList.remove(numberList.size()-1);
                
            }
            else{
                return;
            }
            
        }
        return;

    }
}


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 39. Combination Sum
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> numberList=new ArrayList<>();
        backTrack(candidates,0,target,resultList,numberList);
        return resultList;
    }

    public void backTrack(int[] candidates,int index,int target,List<List<Integer>> resultList, List<Integer> numberList){
        if(target==0){
            //System.out.println(sum +" and Array is "+numberList);
            resultList.add(new ArrayList<>(numberList));
            return;
        }
        if(index<candidates.length){
            if(target>0){
                target=target-candidates[index];
                numberList.add(candidates[index]);
                //System.out.println("Here i: "+i+" Sum= "+sum+" "+Arrays.toString(numberList.toArray()));
                backTrack(candidates,index,target,resultList,numberList);
                target=target+candidates[index];
                numberList.remove(numberList.size()-1);
                backTrack(candidates,index+1,target,resultList,numberList);
         
            }
            // else{
            //     return;
            // }
            
        }
        return;

    }
}

// Striver method
class Solution {

    public List < List < Integer >> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList < > (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

}