/**
 *Problem: 1160. Find Words That Can Be Formed by Characters
 *You are given an array of strings words and a string chars.
 *A string is good if it can be formed by characters from chars (each character can only be used once).
 *Return the sum of lengths of all good strings in words.
 */

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        // Step 1: Initialize Character Counts Array
        for(int i=0;i<chars.length();i++)
        {
            counts[chars.charAt(i)-'a']++;
        }
        int res =0 ;
        // Step 3: Check Words
        for(String s : words)
        {
            if(canForm(s,counts))
                // Step 4: Calculate Lengths
                res+=s.length();
        }
        return res;
    }

    boolean canForm(String word, int[] counts)
    {
        int[] c = new int[26];
        // Step 2: Update Counts Array
        for(int i =0;i<word.length();i++)
        {
            int x = word.charAt(i)-'a';
            c[x]++;
            if(c[x] > counts[x])
                return false;
        }
        return true;
    }
}
