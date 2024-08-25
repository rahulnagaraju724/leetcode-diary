class Solution {
    public int findKthPositive(int[] arr, int k) {
        //1539. Kth Missing Positive Number
        int counter=0;
        int n=1;
        int i=0;
        while(counter!=k && i<arr.length){
            if(n!=arr[i]){
                counter++;              
            }
            else{
                i++;
            }
            n++;
        }
        if(counter==k){
            return n-1;
        }
        return n-1+k-counter;
       
    }
}