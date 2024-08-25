    // class Solution {
    //     public int fib(int n) {
    //         //509. Fibonacci Number
    //         if(n==0){
    //             return 0;
    //         }
    //         int[] f=new int[n+1];
    //         f[0]=0;
    //         f[1]=1;
    //         for(int i=2;i<=n;i=i+1){
    //             f[i]=f[i-1]+f[i-2];
    //         }
    //         return f[n];
    //     }
    // }

    //Another way which is better space complexity
    public class Solution {
        public static int fib(int n) {
            //509. Fibonacci Number
            if (n <= 1) {
                return n;
            }
    
            int prev2 = 0;
            int prev=1;
            for (int i = 2; i <= n; i++) {
                int current = prev2 + prev;
                prev2 = prev;
                prev = current;
            }
    
            return prev;
        }
    }