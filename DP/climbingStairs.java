class Solution {
    public int climbStairs(int n) {
        //70. Climbing Stairs
        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev2 + prev;
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
