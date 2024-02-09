class Solution {
    public int countPrimes(int n) {
        //204. Count Primes
        int count=0;
        if(n<2){
            return 0;
        }
        for(int i=2;i<n;i++){
            boolean prime=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    prime=false;
                    break;
                }
            }
            if(prime){
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int countPrimes(int n) {
        //204. Count Primes
        int count=0;
        if(n<=2){
            return 0;
        }

        ArrayList<Integer> divisors=new ArrayList<>();
        divisors.add(2);
        count++;

        for(int i=3;i<n;i++){
            boolean prime=true;
            for(int j:divisors){
                if(i%j==0){
                    prime=false;
                    break;
                }
            }
            if(prime){
                divisors.add(i);
                count++;
            }
            System.out.println(divisors);
        }
        return count;
    }
}