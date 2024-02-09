class Solution {
    public int sumSubarrayMins(int[] arr) {
        //907. Sum of Subarray Minimums
        List<Integer> subArray=new ArrayList<>();
        int n=arr.length;
        int sum=0;
        System.out.println(Arrays.toString(arr));
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                subArray.add(arr[j]);
                sum+=findMinAndAdd(subArray);           
            }
            subArray.clear();
        }
        return sum;
    }

    public int findMinAndAdd(List<Integer> subArray){
        //System.out.println(subArray);
        return Collections.min(subArray);
    }

}

// Better solution
class Solution {
    private static final long MOD = 1000000007;
    public int sumSubarrayMins(int[] arr) {   
        //907. Sum of Subarray Minimums
        int n=arr.length;
        long sum=0;        
        for(int i=0;i<n;i++){
            int minimum=arr[i];
            sum+=arr[i];
            for(int j=i+1;j<n;j++){
                if(arr[j]<minimum){
                    minimum=arr[j];                   
                }
                sum+=minimum;          
            }
        }
        return (int) ((sum % MOD + MOD) % MOD);
    }
}