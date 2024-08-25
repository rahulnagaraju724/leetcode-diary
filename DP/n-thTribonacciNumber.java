class Solution {
    public int tribonacci(int n) {
        //1137. N-th Tribonacci Number
        if(n==0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }

        int a=0;
        int b=1;
        int c=1;
        int tribonacci=0;
        for(int i=3;i<=n;i++){
            tribonacci=a+b+c;
            a=b;
            b=c;
            c=tribonacci;
        }
        return tribonacci;


    }
}

// Recursive solution
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }
}

// Array store
class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        
        return dp[n];
    }
}

// Memoisation
class Solution {
    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(n, memo);
    }
    
    private int helper(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        int result;
        if (n == 0) {
            result = 0;
        } else if (n == 1 || n == 2) {
            result = 1;
        } else {
            result = helper(n - 1, memo) + helper(n - 2, memo) + helper(n - 3, memo);
        }
        
        memo.put(n, result);
        return result;
    }
}

// Best memoisation
class Solution{

    private int memoizationUtil(int n, int[] dp) {
		if (n < 2) {
			return n;
		}
		if (n == 2) {
			return 1;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		dp[n] = memoizationUtil(n - 1, dp) + memoizationUtil(n - 2, dp) + memoizationUtil(n - 3, dp);
		return dp[n];
	}

	private int memoization(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return memoizationUtil(n, dp);
	}

	public int tribonacci(int n) {
		// return tabulation(n);
		// return spaceOptimizeTabulation(n);
		return memoization(n);
	}

}