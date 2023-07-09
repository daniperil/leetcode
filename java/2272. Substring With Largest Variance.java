/**
 *Problem: 2272. Substring With Largest Variance
 *The variance of a string is defined as the largest difference between the number of occurrences of any 2 characters present in the string. Note the two characters may or may not be the same.
 *Given a string s consisting of lowercase English letters only, return the largest variance possible among all substrings of s.
 *A substring is a contiguous sequence of characters within a string.
 */

class Solution {
    public int largestVariance(String s) {
        //Kadane's algorithm is a dynamic programming algorithm that finds the maximum subarray sum in an array of integers.
        int[] counter = new int[26];
        for (char ch : s.toCharArray()) {
            counter[(int)(ch - 'a')]++;
        }
        int globalMax = 0;
        
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                // major and minor cannot be the same, and both must appear in s.
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue;
                }
                
                // Find the maximum variance of major - minor.        
                char major = (char)('a' + i);
                char minor = (char)('a' + j);
                int majorCount = 0;
                int minorCount = 0;
                
                // The remaining minor in the rest of s.
                int restMinor = counter[j];
                
                for (char ch : s.toCharArray()) {    
                    if(ch == major) {
                        majorCount++;
                    }
                    if(ch == minor) {
                        minorCount++;
                        restMinor--;
                    }
                    
                    // Only update the variance if there is at least one minor.
                    if (minorCount > 0)
                        globalMax = Math.max(globalMax, majorCount - minorCount);
                    
                    // We can discard the previous string if there is at least one remaining minor.
                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0;
                        minorCount = 0;
                    }
                }
            }
        }
        
        return globalMax;
    }
}
