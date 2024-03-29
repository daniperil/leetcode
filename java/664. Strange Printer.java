/**
 *Problem: 664. Strange Printer
 *There is a strange printer with the following two special properties:
 *The printer can only print a sequence of the same character each time.
 *At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
 *Given a string s, return the minimum number of turns the printer needed to print it.
 */

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int i = n-1; i >= 0; --i) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; ++j) {
                dp[i][j] = dp[i][j-1] + 1;
                for (int k = i; k < j; ++k) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + (k+1<=j-1 ? dp[k+1][j-1] : 0));
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
