/**
 *Problem: 1768. Merge Strings Alternately
 *You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *Return the merged string.
 */

class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int x = word1.length();
        int y = word2.length();

        StringBuilder resp = new StringBuilder();

        int i = 0, j = 0;

        while(i < x || j < y){
            if(i<x){
                resp.append(word1.charAt(i++));
            }
            if(j<y){
                resp.append(word2.charAt(j++));
            }
        }
        return resp.toString();
    }
}
