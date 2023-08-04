/**
 *Problem: 139. Word Break
 *Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Dynamic programming i.e. dp
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        //Empty string can always be segmented.
        dp[0]= true;
        int max_len= 0;
        for(String word: wordDict){
            max_len = Math.max(max_len, word.length());
        }

        for(int i = 1; i <= n; i++){
            for(int j = i -1; j>=Math.max(i-max_len-1,0); j--){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

//The use of dynamic programming ensures that we are not recomputing solutions to subproblems, and the consideration of the maximum word length helps in avoiding unnecessary iterations, making this approach both elegant and efficient.

/**
Complexity
Time complexity: ( O(n * m) ), where ( n ) is the length of the string and ( m ) is the maximum length of a word in the dictionary.
Space complexity: ( O(n) )
 */
