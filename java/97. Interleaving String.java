/**
 *Problem: 97. Interleaving String
 *Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
 *s = s1 + s2 + ... + sn
 *t = t1 + t2 + ... + tm
 *|n - m| <= 1
 *The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 *Note: a + b is the concatenation of strings a and b.
 */

public class Solution {
    //1D Dynamic programming
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; ++j) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[n];
    }
}

/**
Complexity:
The primary advantage of this 1D DP approach is its space efficiency. While it maintains the same time complexity as the 2D DP approach O(m×n)O(m \times n)O(m×n), the space complexity is optimized to O(min⁡(m,n))O(\min(m, n))O(min(m,n)).

Time Complexity:

The solution iterates over each character of s1 and s2 once, leading to a complexity of O(m×n)O(m \times n)O(m×n).
Space Complexity:

The space complexity is optimized to O(min⁡(m,n))O(\min(m,n))O(min(m,n)) as we're only using a single 1D array instead of a 2D matrix. */
