/**
 *Problem: 1662. Check If Two String Arrays are Equivalent
 *Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *A string is represented by an array if the array elements concatenated in order forms the string.
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for(String word : word1){
            str1.append(word);
        }
        for(String word : word2){
            str2.append(word);
        }
        String s1 = str1.toString();
        String s2 = str2.toString();

        if(s1.equals(s2)){
            return true;
        }
        else{
            return false;
        }
    }
}
