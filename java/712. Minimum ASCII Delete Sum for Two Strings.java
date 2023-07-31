/**
 *Problem: 712. Minimum ASCII Delete Sum for Two Strings
 *Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 */

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        //Space-Optimized Bottom-up Dynamic Programming

        // Make sure s2 is smaller string
        if (s1.length() < s2.length()) {
            return minimumDeleteSum(s2, s1);
        }
        
        // Case for empty s1
        int m = s1.length(), n = s2.length();
        int[] currRow = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            currRow[j] = currRow[j - 1] + s2.charAt(j - 1);
        }
        
        // Compute answer row-by-row
        for (int i = 1; i <= m; i++) {
            
            int diag = currRow[0];
            currRow[0] += s1.charAt(i - 1);
            
            for (int j = 1; j <= n; j++) {

                int answer;
                
                // If characters are the same, the answer is top-left-diagonal value
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    answer = diag;
                }
                
                // Otherwise, the answer is minimum of top and left values with
                // deleted character's ASCII value
                else {
                    answer = Math.min(
                        s1.charAt(i - 1) + currRow[j],
                        s2.charAt(j - 1) + currRow[j - 1]
                    );
                }
                
                // Before overwriting currRow[j] with answer, save it in diag
                // for the next column
                diag = currRow[j];
                currRow[j] = answer;
            }
        }
        
        // Return the answer
        return currRow[n];
    }
}

/**
Time complexity: O(M⋅N)O(M \cdot N)O(M⋅N).

There are two nested for loops, thus there will be M⋅NM \cdot NM⋅N iterations. In each iteration, we are doing constant work. Thus, the time complexity is O(M⋅N)O(M \cdot N)O(M⋅N).

Space complexity: O(min⁡(M,N))O(\min(M, N))O(min(M,N)).

We are using a one-dimensional array of size min⁡(M,N)+1\min(M, N) + 1min(M,N)+1 to store the current row. Thus, the space complexity is O(min⁡(M,N))O(\min(M, N))O(min(M,N)).
 */
