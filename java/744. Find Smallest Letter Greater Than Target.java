/**
 *Problem: 744. Find Smallest Letter Greater Than Target
 *You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
 *Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
 */

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if(letters[0]>target){
            return letters[0];
        }

        int index = 0;
        char resp= '@';

        while(resp == '@' && index<letters.length){
            if(letters[index]>target){
                resp = letters[index];
            }
            index++;
        }

        if(resp == '@'){
            resp = letters[0];
        }
   
        return resp;
    }
}
