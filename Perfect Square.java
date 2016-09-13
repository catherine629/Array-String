// Perfect Square - dp
public class Solution1 {
    public int numSquares(int n) {
         int[] dp = new int[n + 1];
         for (int i = 1; i <= n; i++) {
             int min = Integer.MAX_VALUE;
             for (int j = 1; j * j <= i; j++) {
                 min = Math.min(min, 1 + dp[i - j * j]);
             }
             dp[i] = min;
         }
         return dp[n];
    }
}
// Perfect Square - greedy
public class Solution2 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        return findN(n, dp);
    }
    
    private int findN(int n, int[] dp) {
        if (n == 0) {
            return 0;
        } else if (dp[n] != 0) {
            return dp[n];
        } else {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i * i <= n; i++) {
                int curr = 1 + findN(n - i * i, dp);
                min = Math.min(min, curr);
            }
            dp[n] = min;
            return dp[n];
        }
    }
}
