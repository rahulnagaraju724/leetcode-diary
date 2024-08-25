class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //77. Combinations
        List<List<Integer>> results=new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        combine(n,k,results,result);
        return results;
    }

    public void combine(int n, int k, List<List<Integer>> results, List<Integer> result){
        if(result.size()==k){
            results.add(new ArrayList<>(result));
            return;
        }

        while(n>0){
            result.add(n);
            combine(n-1,k,results,result);
            n--;
            result.remove(result.size()-1);
            //combine(n-1,k,results)
        }
        return;
    }
    
}